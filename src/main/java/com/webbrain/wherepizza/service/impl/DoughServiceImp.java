package com.webbrain.wherepizza.service.impl;

import com.webbrain.wherepizza.dto.DoughCreateDto;
import com.webbrain.wherepizza.dto.DoughDto;
import com.webbrain.wherepizza.exception.DoughNotFoundException;
import com.webbrain.wherepizza.entity.Dough;
import com.webbrain.wherepizza.entity.Size;
import com.webbrain.wherepizza.repository.DoughRepository;
import com.webbrain.wherepizza.repository.SizeRepository;
import com.webbrain.wherepizza.service.DoughService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DoughServiceImp implements DoughService{
    private final DoughRepository doughRepository;
    private final SizeRepository sizeRepository;

    public DoughServiceImp(DoughRepository doughRepository, SizeRepository sizeRepository) {
        this.doughRepository = doughRepository;
        this.sizeRepository = sizeRepository;
    }

    @Override
    public List<Dough> saveAll(List<DoughCreateDto> doughDtoList) {
        List<Dough> doughList = new ArrayList<>();

        Set<Size> sizeSet = new HashSet<>();
        for (DoughCreateDto dto : doughDtoList) {
            for (Long sizeId : dto.getSize()) {
                Optional<Size> optionalSize = sizeRepository.findById(sizeId);
                if (optionalSize.isPresent()) {
                    Size size = optionalSize.get();
                    sizeSet.add(size);
                }
            }

            doughList.add(new Dough(dto.getName(), sizeSet, dto.getPrice()));
        }
        return doughRepository.saveAll(doughList);
    }

    @Override
    public List<Dough> findAll() {
        return doughRepository.findAll();
    }

    @Override
    public Dough update(Long doughId, DoughDto dto) {
        if (!doughRepository.existsById(doughId))
            throw new DoughNotFoundException("Dough Not Found");

        Optional<Dough> optionalDough = doughRepository.findById(doughId);
        Dough dough = optionalDough.get();
        dough.setName(dto.getName());
        dough.setPrice(dto.getPrice());
        return doughRepository.save(dough);
    }

    @Override
    public String deleteSize(Long doughId) {
        if (!doughRepository.existsById(doughId))
            throw new DoughNotFoundException("Dough Not Found");

        doughRepository.deleteById(doughId);
        return "Successfully deleted";
    }
}
