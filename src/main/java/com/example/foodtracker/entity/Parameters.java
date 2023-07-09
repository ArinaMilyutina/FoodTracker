package com.example.foodtracker.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Parameters extends AbstractEntity{
    private int age;
    private int height;
    private int weight;
    private double norma;
}
