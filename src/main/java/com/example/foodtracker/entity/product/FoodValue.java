package com.example.foodtracker.entity.product;

import com.example.foodtracker.entity.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "food_value")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodValue extends AbstractEntity {
    private int calories;
    private int proteins;
    private int fats;
    private int carbohydrates;
}
