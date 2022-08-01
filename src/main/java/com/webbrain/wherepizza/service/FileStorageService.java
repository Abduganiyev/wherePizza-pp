package com.webbrain.wherepizza.service;

import com.webbrain.wherepizza.entity.Attachment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public interface FileStorageService {
    /**
     * Upload File To DB
     * @param multipartFile - Input file
     * @return Entity
     */
    Attachment uploadFileToDB(MultipartFile multipartFile) throws IOException;

    Attachment downloadFileById(Long fileId) throws FileNotFoundException;

    String deleteById(Long id);

    List<Attachment> findAll();
}
