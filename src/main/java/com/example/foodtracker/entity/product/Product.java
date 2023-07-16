package com.example.foodtracker.entity.product;

import com.example.foodtracker.entity.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends AbstractEntity {
    private String productName;
    private String barcode;
    private int calories;
    private int proteins;
    private int fats;
    private int carbohydrates;
}
