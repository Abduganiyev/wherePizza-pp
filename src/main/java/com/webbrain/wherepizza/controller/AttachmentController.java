package com.webbrain.wherepizza.controller;

import com.webbrain.wherepizza.model.Attachment;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/attachment")
@RequiredArgsConstructor
public class AttachmentController {
    @PostMapping
    private Attachment saveAll() {
        return null;
    }
}
