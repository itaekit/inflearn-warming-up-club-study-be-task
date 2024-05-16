package com.warmingup.apipractice.dto.fruit.response;

import java.time.LocalDate;

public class FruitListElementResponse {
    private final String name;
    private final Long price;
    private final LocalDate warehousingDate;

    public FruitListElementResponse(String name, Long price, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }
}
