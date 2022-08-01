package com.webbrain.wherepizza.service;

import com.webbrain.wherepizza.dto.DoughCreateDto;
import com.webbrain.wherepizza.dto.DoughDto;
import com.webbrain.wherepizza.entity.Dough;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoughService {
    List<Dough> saveAll(List<DoughCreateDto> doughDtoList);

    List<Dough> findAll();

    Dough update(Long doughId, DoughDto dto);

    String deleteSize(Long sizeId);
}