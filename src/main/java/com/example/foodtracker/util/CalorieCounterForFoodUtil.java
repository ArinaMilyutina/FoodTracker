package com.example.foodtracker.util;

import org.springframework.stereotype.Component;


@Component
public class CalorieCounterForFoodUtil {
    private static final double HUNDRED = 100;

    public double calculateCalories(double g, double calories) {
        return g * calories / HUNDRED;
    }

    public double calculateProteins(double g, double proteins) {
        return g * proteins / HUNDRED;
    }

    public double calculateFats(double g, double fats) {
        return g * fats / HUNDRED;
    }

    public double calculateCarbohydrates(double g, double carbohydrates) {
        return g * carbohydrates / HUNDRED;
    }

}
