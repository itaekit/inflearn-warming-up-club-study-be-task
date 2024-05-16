package com.warmingup.apipractice.dto.fruit.response;

public class FruitSalesResponse {
    private final Long salesAmount;
    private final Long notSalesAmount;

    public FruitSalesResponse(Long salesAmount, Long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public Long getSalesAmount() {
        return salesAmount;
    }

    public Long getNotSalesAmount() {
        return notSalesAmount;
    }
}
