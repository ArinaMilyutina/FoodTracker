package com.example.foodtracker.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @Enumerated(EnumType.STRING)
    private ActivityLevel activityLevel;
    @OneToMany(cascade = CascadeType.ALL)
    private List<NormaOfCalories> normaOfCalories;
}
