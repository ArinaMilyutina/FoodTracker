package com.example.foodtracker.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @NotNull
    @DecimalMin(value = "0", message = "Check the correctness of the entered data.")
    private int calories;
    @NotNull
    @DecimalMin(value = "0", message = "Check the correctness of the entered data.")
    private int proteins;
    @NotNull
    @DecimalMin(value = "0", message = "Check the correctness of the entered data.")
    private int fats;
    @NotNull
    @DecimalMin(value = "0", message = "Check the correctness of the entered data.")
    private int carbohydrates;
    @NotBlank
    @NotNull
    @NotEmpty
    private String productName;
    @NotBlank
    @NotNull
    @NotEmpty
    private String barcode;
    private int grams;

}
