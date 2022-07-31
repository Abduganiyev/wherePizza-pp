package com.webbrain.wherepizza.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoughCreateDto {
    private String name;
    private Set<Long> size;
    private Double price;
}
