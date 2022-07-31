package com.webbrain.wherepizza.controller;

import com.webbrain.wherepizza.dto.StatusPizzaDto;
import com.webbrain.wherepizza.model.StatusPizza;
import com.webbrain.wherepizza.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/statuses")
@RequiredArgsConstructor
public class StatusController {
    private final StatusService statusService;

    @PostMapping
    private List<StatusPizza> saveAll(@RequestBody List<StatusPizzaDto> statusPizzaDtoList) {
        return statusService.saveAll(statusPizzaDtoList);
    }

    @GetMapping
    private List<StatusPizza> findAll() {
        return statusService.findAll();
    }

    @PutMapping("/{id}")
    private StatusPizza update(@PathVariable("id") Long statusId, @RequestBody StatusPizzaDto statusPizzaDto) {
        return statusService.update(statusId, statusPizzaDto);
    }

    @DeleteMapping("/{id}")
    private String delete(@PathVariable("id") Long statusId) {
        return statusService.delete(statusId);
    }

}
