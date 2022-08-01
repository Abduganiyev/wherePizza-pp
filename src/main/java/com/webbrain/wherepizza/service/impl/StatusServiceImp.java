package com.webbrain.wherepizza.service.impl;

import com.webbrain.wherepizza.dto.StatusPizzaDto;
import com.webbrain.wherepizza.exception.StatusNotFoundException;
import com.webbrain.wherepizza.entity.StatusPizza;
import com.webbrain.wherepizza.repository.StatusRepository;
import com.webbrain.wherepizza.service.StatusService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImp implements StatusService{
    private final StatusRepository statusRepository;

    public StatusServiceImp(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public List<StatusPizza> saveAll(List<StatusPizzaDto> statusPizzaDtoList) {
        List<StatusPizza> statusPizzaList = new ArrayList<>();
        for (StatusPizzaDto dto : statusPizzaDtoList) {
            statusPizzaList.add(new StatusPizza(dto.getName()));
        }
        return statusRepository.saveAll(statusPizzaList);
    }

    @Override
    public List<StatusPizza> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public StatusPizza update(Long statusId, StatusPizzaDto statusPizzaDto) {
        if (!statusRepository.existsById(statusId))
            throw new StatusNotFoundException("Status Not Found");

        Optional<StatusPizza> optionalStatusPizza = statusRepository.findById(statusId);
        StatusPizza statusPizza = optionalStatusPizza.get();
        statusPizza.setName(statusPizzaDto.getName());
        return statusRepository.save(statusPizza);
    }

    @Override
    public String delete(Long statusId) {
        if (!statusRepository.existsById(statusId))
            throw new StatusNotFoundException("Status Not Found");

        statusRepository.deleteById(statusId);
        return "Successfully deleted";
    }
}
