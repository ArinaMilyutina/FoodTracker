package com.example.foodtracker.entity.user;

import com.example.foodtracker.entity.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "norma_of_calories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NormaOfCalories extends AbstractEntity {
    private double normaOfCalories;
}
