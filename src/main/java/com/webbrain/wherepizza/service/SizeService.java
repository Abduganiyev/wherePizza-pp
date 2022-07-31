package com.webbrain.wherepizza.service;

import com.webbrain.wherepizza.dto.SizeDto;
import com.webbrain.wherepizza.model.Size;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SizeService {
    List<Size> saveAll(List<SizeDto> sizeDtoList);

    List<Size> findAll();

    Size update(Long sizeId, SizeDto dto);

    String deleteSize(Long sizeId);
}
