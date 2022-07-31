package com.webbrain.wherepizza.controller;

import com.webbrain.wherepizza.dto.SizeDto;
import com.webbrain.wherepizza.model.Size;
import com.webbrain.wherepizza.service.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sizes")
@RequiredArgsConstructor
public class SizeController {
    private final SizeService sizeService;

    @PostMapping
    private List<Size> saveAll(@RequestBody List<SizeDto> sizeDtoList) {
        return sizeService.saveAll(sizeDtoList);
    }

    @GetMapping
    private List<Size> findAll() {
        return sizeService.findAll();
    }

    @PutMapping("/{id}")
    private Size updateSize(@PathVariable("id") Long sizeId, SizeDto dto) {
        return sizeService.update(sizeId,dto);
    }

    @DeleteMapping("/{id}")
    private String deleteSize(@PathVariable("id") Long sizeId) {
        return sizeService.deleteSize(sizeId);
    }
}
