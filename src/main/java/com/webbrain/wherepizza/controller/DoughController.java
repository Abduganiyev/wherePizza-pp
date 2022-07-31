package com.webbrain.wherepizza.controller;

import com.webbrain.wherepizza.dto.DoughCreateDto;
import com.webbrain.wherepizza.dto.DoughDto;
import com.webbrain.wherepizza.dto.SizeDto;
import com.webbrain.wherepizza.model.Dough;
import com.webbrain.wherepizza.model.Size;
import com.webbrain.wherepizza.service.DoughService;
import com.webbrain.wherepizza.service.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/doughs")
@RequiredArgsConstructor
public class DoughController {
    private final DoughService doughService;

    @PostMapping
    private List<Dough> saveAll(@RequestBody List<DoughCreateDto> doughDtoList) {
        return doughService.saveAll(doughDtoList);
    }

    @GetMapping
    private List<Dough> findAll() {
        return doughService.findAll();
    }

    @PutMapping("/{id}")
    private Dough updateSize(@PathVariable("id") Long doughId, DoughDto dto) {
        return doughService.update(doughId,dto);
    }

    @DeleteMapping("/{id}")
    private String deleteSize(@PathVariable("id") Long sizeId) {
        return doughService.deleteSize(sizeId);
    }
}
