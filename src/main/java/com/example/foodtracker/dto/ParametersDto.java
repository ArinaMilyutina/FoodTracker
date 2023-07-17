package com.example.foodtracker.dto;

import com.example.foodtracker.entity.user.ActivityLevel;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParametersDto {
    @NotNull
    @DecimalMin(value = "0", message = "Check the correctness of the entered data.")
    private int age;
    @NotNull
    @DecimalMin(value = "0", message = "Check the correctness of the entered data.")
    private int height;
    @NotNull
    @DecimalMin(value = "0", message = "Check the correctness of the entered data.")
    private int weight;
    private double normaOfCalories;
    private double normaOfCaloriesForWeightLoss;
    private double normaOfCaloriesForWeightGain;
    @NotNull
    @NotBlank
    @NotEmpty
    private ActivityLevel activityLevel;
}
