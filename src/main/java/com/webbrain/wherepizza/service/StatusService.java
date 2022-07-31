package com.webbrain.wherepizza.service;

import com.webbrain.wherepizza.dto.StatusPizzaDto;
import com.webbrain.wherepizza.model.StatusPizza;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatusService {
    List<StatusPizza> saveAll(List<StatusPizzaDto> statusPizzaDtoList);

    List<StatusPizza> findAll();

    StatusPizza update(Long statusId, StatusPizzaDto statusPizzaDto);

    String delete(Long statusId);
}
