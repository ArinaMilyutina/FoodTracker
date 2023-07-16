package com.example.foodtracker.entity.product;

import com.example.foodtracker.entity.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "new_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewProduct extends AbstractEntity {
    @NotNull
    private String productName;
    private String barcode;
    private double calories;
    private double proteins;
    private double fats;
    private double carbohydrates;
    @DecimalMin(value = "0")
    private double countGram;
}
