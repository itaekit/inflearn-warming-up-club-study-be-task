package com.warmingup.apipractice.dto.fruit.request;

import java.time.LocalDate;

public class FruitCreateRequest {
    private String name;
    private LocalDate warehousingDate;
    private Long price;
    private boolean is_sold;

    public FruitCreateRequest(String name, LocalDate warehousingDate, Long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        is_sold = false;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public Long getPrice() {
        return price;
    }
}
