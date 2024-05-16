package com.warmingup.apipractice.domain;

public class FruitSalesStatus {
    private String name;
    private Long price;
    private boolean isSold;

    public FruitSalesStatus(String name, Long price, boolean isSold) {
        this.name = name;
        this.price = price;
        this.isSold = isSold;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public boolean isSold() {
        return isSold;
    }
}
