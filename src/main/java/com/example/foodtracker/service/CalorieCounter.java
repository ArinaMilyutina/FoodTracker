package com.example.foodtracker.service;


import com.example.foodtracker.entity.Parameters;
import org.springframework.stereotype.Component;


@Component
public class CalorieCounter {
    private static final double MINIMUM = 1.2;
    private static final double LOW = 1.375;
    private static final double AVERAGE = 1.55;
    private static final double HIGH = 1.725;
    private static final double VERY_HIGH = 1.9;

    public double minimumLevel(int age, int height, int weight) {
        return normaOfCalories(age, height, weight) * MINIMUM;
    }


    public double lowLevel(int age, int height, int weight) {
        return normaOfCalories(age, height, weight) * LOW;
    }


    public double averageLevel(int age, int height, int weight) {
        return normaOfCalories(age, height, weight) * AVERAGE;
    }


    public double highLevel(int age, int height, int weight) {
        return normaOfCalories(age, height, weight) * HIGH;
    }

    public double veryHighLevel(int age, int height, int weight) {
        return normaOfCalories(age, height, weight) * VERY_HIGH;
    }

    private static double normaOfCalories(int age, int height, int weight) {
        return weight * 10 + height * 6.25 - age * 5;
    }

    public double calculateNormaOfCalories(Parameters parameters) {

        switch (parameters.getActivityLevel()) {
            case "minimum" -> {
                return minimumLevel(parameters.getAge(), parameters.getHeight(), parameters.getWeight());
            }
            case "low" -> {
                return lowLevel(parameters.getAge(), parameters.getHeight(), parameters.getWeight());
            }
            case "average" -> {
                return averageLevel(parameters.getAge(), parameters.getHeight(), parameters.getWeight());
            }
            case "high" -> {
                return highLevel(parameters.getAge(), parameters.getHeight(), parameters.getWeight());
            }
            case "very high" -> {
                return veryHighLevel(parameters.getAge(), parameters.getHeight(), parameters.getWeight());
            }
        }
        return 0;

    }

}
