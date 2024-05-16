package com.warmingup.apipractice.controller;

import com.warmingup.apipractice.dto.fruit.request.FruitCreateRequest;
import com.warmingup.apipractice.dto.fruit.request.FruitUpdateRequest;
import com.warmingup.apipractice.dto.fruit.response.FruitCountResponse;
import com.warmingup.apipractice.dto.fruit.response.FruitListElementResponse;
import com.warmingup.apipractice.dto.fruit.response.FruitSalesResponse;
import com.warmingup.apipractice.service.FruitServiceV1;
import com.warmingup.apipractice.service.FruitServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/fruit")
public class FruitController {
    private final FruitServiceV2 fruitServiceV2;

    public FruitController(FruitServiceV2 fruitServiceV2) {
        this.fruitServiceV2 = fruitServiceV2;
    }

    @PostMapping
    public void saveFruit(@RequestBody FruitCreateRequest request) {
        fruitServiceV2.saveFruit(request);
    }

    @PutMapping
    public void updateFruit(@RequestBody FruitUpdateRequest request) {
        fruitServiceV2.updateFruit(request);
    }

    @GetMapping("/stat")
    public FruitSalesResponse getFruitSalesResult(@RequestParam String name) {
        return fruitServiceV2.getFruitSalesResult(name);
    }

    @GetMapping("/count")
    public FruitCountResponse getFruitCountResult(@RequestParam String name) {
        return fruitServiceV2.getFruitCountResult(name);
    }

    @GetMapping("/list")
    public List<FruitListElementResponse> getFruitList(@RequestParam String option, @RequestParam Long price) {
        return fruitServiceV2.getFruitList(option, price);
    }
}
