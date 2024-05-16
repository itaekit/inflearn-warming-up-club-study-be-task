package com.warmingup.apipractice.controller;

import com.warmingup.apipractice.dto.fruit.request.FruitCreateRequest;
import com.warmingup.apipractice.dto.fruit.request.FruitUpdateRequest;
import com.warmingup.apipractice.dto.fruit.response.FruitSalesResponse;
import com.warmingup.apipractice.service.FruitService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/fruit")
public class FruitController {
    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping
    public void saveFruit(@RequestBody FruitCreateRequest request) {
        fruitService.saveFruit(request);
    }

    @PutMapping
    public void updateFruit(@RequestBody FruitUpdateRequest request) {
        fruitService.updateFruit(request);
    }

    @GetMapping("/stat")
    public FruitSalesResponse getFruitSalesResult(@RequestParam String name) {
        return fruitService.getFruitSalesResult(name);
    }

}
