package com.example.foodtracker.service;


import org.springframework.stereotype.Component;


@Component
public class NormOfCalories {
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

}
