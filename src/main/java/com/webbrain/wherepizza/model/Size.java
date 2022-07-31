package com.webbrain.wherepizza.model;

import com.webbrain.wherepizza.model.template.AbsEntity;
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
public class Size extends AbsEntity {
    @Column(nullable = false,unique = true)
    private Integer size;

    @Column(nullable = false)
    private Double price;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public Size(Integer size, Double price) {
        this.size = size;
        this.price = price;
    }
}
