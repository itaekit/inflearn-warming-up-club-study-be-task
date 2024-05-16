package com.warmingup.apipractice.service;

import com.warmingup.apipractice.domain.Fruit;
import com.warmingup.apipractice.dto.fruit.response.FruitSalesResponse;
import com.warmingup.apipractice.repository.FruitRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
public class FruitMemoryRepository implements FruitRepository {
    private List<Fruit> fruitList;

    public FruitMemoryRepository() {
        fruitList = new ArrayList<>();
    }

    @Override
    public void saveFruit(String name, LocalDate date, Long price) {
        fruitList.add(new Fruit( Long.valueOf(fruitList.size() + 1), name, price, date));
    }

    @Override
    public void updateFruit(Long id) {
        for (int i = 0; i < fruitList.size(); i++) {
            if (fruitList.get(i).getId().longValue() == id.longValue()) {
                fruitList.get(i).updateIsSold();
            }
        }
    }

    @Override
    public FruitSalesResponse getFruitSalesResult(String name) {
        Long salesAmount = fruitList.stream().filter(fruit -> fruit.isSold()).mapToLong(f -> f.getPrice()).sum();
        Long notSalesAmount = fruitList.stream().filter(fruit -> !fruit.isSold()).mapToLong(f -> f.getPrice()).sum();
        System.out.println("계산완료 : " +  salesAmount + ", " + notSalesAmount);
        return new FruitSalesResponse(salesAmount, notSalesAmount);
    }
}
