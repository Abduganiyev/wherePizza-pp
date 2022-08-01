package com.webbrain.wherepizza.controller;

import com.webbrain.wherepizza.entity.Pizza;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaController {
    @PostMapping()
    private Pizza save() {
        return null;
    }
}
