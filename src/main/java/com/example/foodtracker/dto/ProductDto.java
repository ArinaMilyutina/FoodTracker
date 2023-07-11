package com.example.foodtracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private int calories;
    private int proteins;
    private int fats;
    private int carbohydrates;
    private String productName;
    private String barcode;
}
