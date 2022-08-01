package com.webbrain.wherepizza.dto;

import com.webbrain.wherepizza.entity.Attachment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientsDto {
    private String name;

    private Long prefixId;

    private Double price;
}
