package com.webbrain.wherepizza.controller;

import com.webbrain.wherepizza.dto.IngredientsDto;
import com.webbrain.wherepizza.entity.Ingredients;
import com.webbrain.wherepizza.service.IngredientsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/ingredients")
public class IngredientsController {
    private IngredientsService ingredientsService;

    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @PostMapping
    private List<Ingredients> saveAll(@RequestBody List<IngredientsDto> dtoList) {
        return ingredientsService.saveAll(dtoList);
    }
}
