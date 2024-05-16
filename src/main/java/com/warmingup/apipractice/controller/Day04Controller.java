package com.warmingup.apipractice.controller;

import com.warmingup.apipractice.domain.FruitSalesStatus;
import com.warmingup.apipractice.dto.fruit.request.FruitCreateRequest;
import com.warmingup.apipractice.dto.fruit.request.FruitUpdateRequest;
import com.warmingup.apipractice.dto.fruit.response.FruitSalesResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fruit")
public class Day04Controller {
    private final JdbcTemplate jdbcTemplate;

    public Day04Controller(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping
    public void saveFruit(@RequestBody FruitCreateRequest request) {
        String sql = "INSERT INTO fruit (name, warehousing_date, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    @PutMapping
    public void updateFruit(@RequestBody FruitUpdateRequest request) {
        String sql = "UPDATE fruit SET is_sold = 1 WHERE id = ?";
        jdbcTemplate.update(sql, request.getId());
    }

    @GetMapping("/stat")
    public FruitSalesResponse getFruitSalesResult(@RequestParam String name) {
        String sql = "SELECT * FROM fruit WHERE name = ?";
        List<FruitSalesStatus> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
            String fruitName = rs.getString("name");
            Long price = rs.getLong("price");
            boolean isSold = rs.getBoolean("is_sold");
            return new FruitSalesStatus(fruitName, price, isSold);
        }, name);

        long salesAmount = 0L;
        long notSalesAmount = 0L;

        for (FruitSalesStatus fruitSalesStatus : list) {
            if (fruitSalesStatus.isSold()) {
                salesAmount += fruitSalesStatus.getPrice();
            } else {
                notSalesAmount += fruitSalesStatus.getPrice();
            }
        }

        return new FruitSalesResponse(salesAmount, notSalesAmount);
    }

}
