package com.warmingup.apipractice.controller;

import com.warmingup.apipractice.dto.calc.request.NumbersRequest;
import com.warmingup.apipractice.dto.calc.response.CalculatorResultResponse;
import com.warmingup.apipractice.dto.dayoftheweek.DayOfTheWeekResponse;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class Day02Controller {
    @GetMapping("/api/v1/calc")
    public CalculatorResultResponse calculate(
            @RequestParam(name="num1") int num1,
            @RequestParam(name="num2") int num2) {
        return new CalculatorResultResponse(num1, num2);
    }

    @GetMapping("/api/v1/day-of-the-week")
    public DayOfTheWeekResponse getDayOfTheWeek(@RequestParam LocalDate date) {
        return new DayOfTheWeekResponse(date);
    }

    @PostMapping("/api/v1/sum-all")
    public Integer sumAll(@RequestBody NumbersRequest request) {
        return request.getNumbers().stream().mapToInt(num -> num).sum();
    }
}
