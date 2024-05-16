package com.warmingup.apipractice.domain;

import com.warmingup.apipractice.dto.fruit.response.FruitListElementResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    List<Fruit> findAllByName(String name);
    List<Fruit> findAllByPriceGreaterThan(Long price);
    List<Fruit> findAllByPriceLessThan(Long price);
}
