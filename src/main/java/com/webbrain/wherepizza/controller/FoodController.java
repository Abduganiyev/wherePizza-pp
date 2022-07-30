package com.webbrain.wherepizza.controller;

import com.webbrain.wherepizza.model.Pizza;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {
    @PostMapping()
    private Pizza save() {
        return null;
    }
}
