package com.example.foodtracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "parameters")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Parameters extends AbstractEntity {
    private int age;
    private int height;
    private int weight;
    private double norma;
    private String activityLevel;
}
