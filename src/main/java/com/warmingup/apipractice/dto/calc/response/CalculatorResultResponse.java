package com.warmingup.apipractice.dto.calc.response;

public class CalculatorResultResponse {
    private final int add;
    private final int minus;
    private final int muliply;

    public CalculatorResultResponse(int num1, int num2) {
        this.add = num1 + num2;
        this.minus = num1 - num2;
        this.muliply = num1 * num2;
    }

    public int getAdd() {
        return add;
    }

    public int getMinus() {
        return minus;
    }

    public int getMuliply() {
        return muliply;
    }
}
