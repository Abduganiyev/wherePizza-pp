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
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pizza extends AbsEntity {
    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @ManyToMany
    private Set<Dough> doughSet;

    @ManyToMany
    private Set<StatusPizza> statusPizzaSet;

    @ManyToMany
    private List<Attachment> attachmentList;

    @ManyToMany
    private Set<Ingredients> ingredients;

    @ManyToMany
    private Set<Ingredients> pizzaAdditionals;

    @Column(nullable = false)
    private Double total_price;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

}
