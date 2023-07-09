package com.example.foodtracker.dto;

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
    private double normaCalories;
}
