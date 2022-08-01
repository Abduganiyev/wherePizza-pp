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
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredients extends AbsEntity{
    @Column(nullable = false,unique = true)
    private String name;

    @OneToOne
    private Attachment prefix;

    @Column
    private Double price;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public Ingredients(String name, Attachment prefix, Double price) {
        this.name = name;
        this.prefix = prefix;
        this.price = price;
    }
}
