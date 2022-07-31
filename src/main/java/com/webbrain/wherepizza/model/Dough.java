package com.webbrain.wherepizza.model;

import com.webbrain.wherepizza.model.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dough extends AbsEntity{
    @Column(nullable = false)
    private String name;

    @ManyToMany
    private Set<Size> sizeSet;

    @Column(nullable = false)
    private Double price;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public Dough(String name, Set<Size> sizeSet, Double price) {
        this.name = name;
        this.sizeSet = sizeSet;
        this.price = price;
    }

    public Dough(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
