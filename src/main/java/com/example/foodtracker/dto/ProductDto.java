package com.example.foodtracker.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @NotNull(message = "Enter tha calories product!!!")
    @Min(value = 1, message = "Value must be greater than or equal to 1")
    private int calories;
    @NotNull(message = "Enter tha proteins product!!!")
    private int proteins;
    @NotNull(message = "Enter tha fats product!!!")
    private int fats;
    @NotNull(message = "Enter tha carbohydrates product!!!")
    private int carbohydrates;
    @NotBlank(message = "Enter the name product!!!")
    private String productName;
    @NotBlank(message = "Enter the barcode product!!!")
    private String barcode;
}
