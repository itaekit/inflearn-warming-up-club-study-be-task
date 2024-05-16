package com.warmingup.apipractice.domain;

import java.time.LocalDate;

public class Fruit {
    private Long id;
    private String name;
    private Long price;
    private LocalDate warehousingDate;
    private boolean isSold;

    public Fruit(Long id, String name, Long price, LocalDate warehousingDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
        this.isSold = false;
    }

    public Long getId() {
        return id;
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

    public boolean isSold() {
        return isSold;
    }

    public void updateIsSold() {
        isSold = true;
    }
}
