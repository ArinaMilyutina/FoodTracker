package com.example.foodtracker.dto;

import com.example.foodtracker.entity.parameters.ActivityLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParametersDto {
    private int age;
    private int height;
    private int weight;
    private double normaOfCalories;
    private double normaOfCaloriesForWeightLoss;
    private double normaOfCaloriesForWeightGain;
    private ActivityLevel activityLevel;
}
