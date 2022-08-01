package com.webbrain.wherepizza.entity;

import com.webbrain.wherepizza.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attachment extends AbsEntity{
/*    @Column
    private String name;

    @Column
    private String originalName;

    @Column
    private String contentType;

    @Column
    private Long size;

    @Column
    private Boolean status;

    @Column
    private String path;*/
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String originalName;

    private byte[] data;

    private long size;

    @Column(nullable = false)
    private String contentType;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public Attachment(Long id, String name, String originalName, byte[] data, long size, String contentType) {
        super(id);
        this.name = name;
        this.originalName = originalName;
        this.data = data;
        this.size = size;
        this.contentType = contentType;
    }

    public Attachment(String name, String originalName, byte[] data, long size, String contentType) {
        this.name = name;
        this.originalName = originalName;
        this.data = data;
        this.size = size;
        this.contentType = contentType;
    }
}
