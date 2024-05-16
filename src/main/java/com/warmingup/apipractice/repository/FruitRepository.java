package com.warmingup.apipractice.repository;

import com.warmingup.apipractice.dto.fruit.response.FruitSalesResponse;

import java.time.LocalDate;

public interface FruitRepository {
    void saveFruit(String name, LocalDate date, Long price );
    void updateFruit(Long id);
    FruitSalesResponse getFruitSalesResult(String name);
}
