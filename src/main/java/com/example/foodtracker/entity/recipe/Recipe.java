package com.example.foodtracker.entity.recipe;

import com.example.foodtracker.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "recipes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipe extends AbstractEntity {
    private String name;
    private String description;
    @Lob
    @Column(name = "image", length = 1000)
    private byte[] image;
}
