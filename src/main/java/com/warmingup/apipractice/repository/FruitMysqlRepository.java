package com.warmingup.apipractice.repository;

import com.warmingup.apipractice.domain.FruitSalesStatus;
import com.warmingup.apipractice.dto.fruit.response.FruitSalesResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Primary
public class FruitMysqlRepository implements FruitRepository {
    private final JdbcTemplate jdbcTemplate;

    public FruitMysqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveFruit(String name, LocalDate date, Long price ) {
        String sql = "INSERT INTO fruit (name, warehousing_date, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, name, date, price);
    }


    public void updateFruit(Long id) {
        String sql = "UPDATE fruit SET is_sold = 1 WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public FruitSalesResponse getFruitSalesResult(String name) {
        String sql = "SELECT * FROM fruit WHERE name = ?";
        List<FruitSalesStatus> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
            String fruitName = rs.getString("name");
            Long price = rs.getLong("price");
            boolean isSold = rs.getBoolean("is_sold");
            return new FruitSalesStatus(fruitName, price, isSold);
        }, name);

        Long salesAmount = list.stream().filter(fruit -> fruit.isSold()).mapToLong(f -> f.getPrice()).sum();
        Long notSalesAmount = list.stream().filter(fruit -> !fruit.isSold()).mapToLong(f -> f.getPrice()).sum();
        return new FruitSalesResponse(salesAmount, notSalesAmount);
    }
}
