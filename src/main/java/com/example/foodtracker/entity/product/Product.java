package com.example.foodtracker.entity.product;

import com.example.foodtracker.entity.AbstractEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
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
    private int barcode;
    @OneToOne(cascade = CascadeType.ALL)
    private FoodValue foodValue;
}
