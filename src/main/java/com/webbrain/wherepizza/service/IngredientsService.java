package com.webbrain.wherepizza.service;

import com.webbrain.wherepizza.dto.IngredientsDto;
import com.webbrain.wherepizza.entity.Ingredients;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IngredientsService {
    List<Ingredients> saveAll(List<IngredientsDto> dtoList);
}
