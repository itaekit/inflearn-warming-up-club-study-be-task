package com.warmingup.apipractice.dto.calc.request;

import java.util.ArrayList;
import java.util.List;

public class NumbersRequest {
    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        System.out.println(numbers.size());
        return numbers;
    }
}
