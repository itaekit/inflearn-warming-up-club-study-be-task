package com.warmingup.apipractice.service;

import com.warmingup.apipractice.domain.Fruit;
import com.warmingup.apipractice.domain.FruitRepository;
import com.warmingup.apipractice.dto.fruit.request.FruitCreateRequest;
import com.warmingup.apipractice.dto.fruit.request.FruitUpdateRequest;
import com.warmingup.apipractice.dto.fruit.response.FruitCountResponse;
import com.warmingup.apipractice.dto.fruit.response.FruitListElementResponse;
import com.warmingup.apipractice.dto.fruit.response.FruitSalesResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class FruitServiceV2 {
    private final FruitRepository fruitRepository;

    public FruitServiceV2(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Transactional
    public void saveFruit(@RequestBody FruitCreateRequest request) {
        Fruit fruit = new Fruit(request.getName(), request.getPrice(), request.getWarehousingDate());
        fruitRepository.save(fruit);
    }

    @Transactional
    public void updateFruit(@RequestBody FruitUpdateRequest request) {
        Fruit fruit = fruitRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);
        fruit.updateIsSold();
        fruitRepository.save(fruit);
    }

    @Transactional
    public FruitSalesResponse getFruitSalesResult(@RequestParam String name) {
        List<Fruit> fruitList = fruitRepository.findAllByName(name);

        Long salesAmount =  fruitList.stream().filter(f->f.isSold()).mapToLong(f->f.getPrice()).sum();
        Long notSalesAmount = fruitList.stream().filter(f->!f.isSold()).mapToLong(f->f.getPrice()).sum();

        return new FruitSalesResponse(salesAmount, notSalesAmount);
    }

    @Transactional
    public FruitCountResponse getFruitCountResult(String name) {
        Long count = Long.valueOf(fruitRepository.findAllByName(name).size());
        return new FruitCountResponse(count);
    }

    @Transactional
    public List<FruitListElementResponse> getFruitList(String option, Long price) {
        List<Fruit> fruitList;

        if (option.equals("GTE")) {
            fruitList = fruitRepository.findAllByPriceGreaterThan(price);
        } else if (option.equals("LTE")) {
            fruitList = fruitRepository.findAllByPriceLessThan(price);
        } else {
            throw new IllegalArgumentException("Invalid option");
        }

        List<FruitListElementResponse> fruitListElementResponses = new ArrayList<>();
        for (Fruit fruit : fruitList) {
            fruitListElementResponses.add(new FruitListElementResponse(fruit.getName(), fruit.getPrice(), fruit.getWarehousingDate()));
        }

        return fruitListElementResponses;
    }
}
