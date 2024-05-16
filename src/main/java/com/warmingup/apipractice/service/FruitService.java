package com.warmingup.apipractice.service;

import com.warmingup.apipractice.dto.fruit.request.FruitCreateRequest;
import com.warmingup.apipractice.dto.fruit.request.FruitUpdateRequest;
import com.warmingup.apipractice.dto.fruit.response.FruitSalesResponse;
import com.warmingup.apipractice.repository.FruitRepository;
import org.springframework.stereotype.Service;

@Service
public class FruitService {
    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruit(FruitCreateRequest request) {
        fruitRepository.saveFruit(request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    public void updateFruit(FruitUpdateRequest request) {
        fruitRepository.updateFruit(request.getId());
    }

    public FruitSalesResponse getFruitSalesResult(String name) {
        return fruitRepository.getFruitSalesResult(name);
    }
}
