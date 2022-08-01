package com.webbrain.wherepizza.controller;

import com.webbrain.wherepizza.model.Attachment;
import com.webbrain.wherepizza.response.UploadFileResponse;
import com.webbrain.wherepizza.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/attachment")
@RequiredArgsConstructor
public class AttachmentController {
    private final FileStorageService fileStorageService;
    @PostMapping(value = "/upload_file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    private UploadFileResponse uploadFileToDB(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        Attachment uploadFile = fileStorageService.uploadFileToDB(multipartFile);

        String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/attachments/database/download_file/").path(uploadFile.getId().toString()).toUriString();
        return new UploadFileResponse(uploadFile.getOriginalName(), downloadUrl, multipartFile.getContentType(), multipartFile.getSize());
    }

    @PostMapping(value = "/upload_files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    private List<UploadFileResponse> uploadFilesToDB(@RequestParam("files") List<MultipartFile> multipartFiles) throws IOException {
/*        List<Attachment> uploadFiles = fileStorageService.uploadFilesToDB(multipartFiles);

        List<UploadFileResponse> responseList = new ArrayList<>();
        for (Attachment uploadFile : uploadFiles) {
            String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/attachments/database/download_file/").path(uploadFile.getId().toString()).toUriString();
            UploadFileResponse response = new UploadFileResponse(uploadFile.getOriginalName(), downloadUrl, uploadFile.getContentType(), uploadFile.getSize());
            responseList.add(response);
        }
        return responseList;*/

        List<UploadFileResponse> uploadFileResponseList = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            uploadFileResponseList.add(uploadFileToDB(multipartFile));
        }
        return uploadFileResponseList;
    }
    @GetMapping
    private List<UploadFileResponse> findAll() throws IOException {
        List<UploadFileResponse> uploadFileResponseList = new ArrayList<>();

        List<Attachment> attachments = fileStorageService.findAll();
        for (Attachment attachment : attachments) {
            String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/attachments/database/download_file/").path(attachment.getId().toString()).toUriString();
            UploadFileResponse uploadFileResponse = new UploadFileResponse(attachment.getId(), attachment.getOriginalName(), downloadUrl, attachment.getContentType(), attachment.getSize());
            uploadFileResponseList.add(uploadFileResponse);

        }
        return uploadFileResponseList;
    }
    @GetMapping("/download_file/{id}")
    private ResponseEntity<Resource> downloadFileFromDB(@PathVariable("id") Long fileId, HttpServletRequest request) throws IOException {
        Attachment attachment = fileStorageService.downloadFileById(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getContentType()))
                .body(new ByteArrayResource(attachment.getData()));
    }

    @DeleteMapping("/{id}")
    private String deleteFileById(@PathVariable Long id) {
        return fileStorageService.deleteById(id);
    }
}
