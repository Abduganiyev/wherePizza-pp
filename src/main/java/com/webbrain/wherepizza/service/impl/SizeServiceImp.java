package com.webbrain.wherepizza.service.impl;

import com.webbrain.wherepizza.dto.SizeDto;
import com.webbrain.wherepizza.exception.SizeNotFoundException;
import com.webbrain.wherepizza.model.Size;
import com.webbrain.wherepizza.repository.SizeRepository;
import com.webbrain.wherepizza.service.SizeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SizeServiceImp implements SizeService {
    private final SizeRepository sizeRepository;

    public SizeServiceImp(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    @Override
    public List<Size> saveAll(List<SizeDto> sizeDtoList) {
        List<Size> sizeList = new ArrayList<>();
        for (SizeDto dto : sizeDtoList) {
            sizeList.add(new Size(dto.getSize(), dto.getPrice()));
        }
        return sizeRepository.saveAll(sizeList);
    }

    @Override
    public List<Size> findAll() {
        return sizeRepository.findAll();
    }

    @Override
    public Size update(Long sizeId, SizeDto dto) {
        if (!sizeRepository.existsById(sizeId))
            throw new SizeNotFoundException("Size Not Found");

        Optional<Size> optionalSize = sizeRepository.findById(sizeId);
        Size size = optionalSize.get();
        size.setSize(dto.getSize());
        size.setPrice(dto.getPrice());
        return sizeRepository.save(size);
    }

    @Override
    public String deleteSize(Long sizeId) {
        if (!sizeRepository.existsById(sizeId))
            throw new SizeNotFoundException("Size Not Found");

        sizeRepository.deleteById(sizeId);
        return "Successfully deleted";
    }
}
