package com.webbrain.wherepizza.response;

import com.webbrain.wherepizza.model.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadFileResponse extends AbsEntity{
    private String fileName;
    private String downloadUrl;
    private String type;
    private Long size;

    public UploadFileResponse(Long id, String fileName, String downloadUrl, String type, Long size) {
        super(id);
        this.fileName = fileName;
        this.downloadUrl = downloadUrl;
        this.type = type;
        this.size = size;
    }
}
