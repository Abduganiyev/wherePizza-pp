package com.webbrain.wherepizza.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentPrefixDto {
    private long id;
    private String name;
    private long size;
    private String contentType;
}
