package com.webbrain.wherepizza.service.impl;

import com.webbrain.wherepizza.dto.AttachmentPrefixDto;
import com.webbrain.wherepizza.dto.IngredientsDto;
import com.webbrain.wherepizza.entity.Attachment;
import com.webbrain.wherepizza.entity.Ingredients;
import com.webbrain.wherepizza.exception.FileNotFoundException;
import com.webbrain.wherepizza.repository.AttachmentRepository;
import com.webbrain.wherepizza.repository.IngredientsRepository;
import com.webbrain.wherepizza.service.IngredientsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientsServiceImp implements IngredientsService {
    private final IngredientsRepository ingredientsRepository;
    private final AttachmentRepository attachmentRepository;

    public IngredientsServiceImp(IngredientsRepository ingredientsRepository, AttachmentRepository attachmentRepository) {
        this.ingredientsRepository = ingredientsRepository;
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public List<Ingredients> saveAll(List<IngredientsDto> dtoList) {
        List<Ingredients> ingredientsList = new ArrayList<>();

        for (IngredientsDto dto : dtoList) {
            if (!attachmentRepository.existsById(dto.getPrefixId()))
                throw new FileNotFoundException("Image Not Found");

            Optional<Attachment> optionalAttachment = attachmentRepository.findById(dto.getPrefixId());
            Attachment attachment = optionalAttachment.get();
            Attachment attachment2 = new Attachment(attachment.getId(), attachment.getOriginalName(), attachment.getSize(), attachment.getContentType());

            ingredientsList.add(new Ingredients(dto.getName(), attachment2, dto.getPrice()));
        }
        return ingredientsRepository.saveAll(ingredientsList);
    }
}
