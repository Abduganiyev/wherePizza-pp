package com.webbrain.wherepizza.controller;

import com.webbrain.wherepizza.model.Food;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {
    @PostMapping()
    private Food save() {
        return null;
    }
}
