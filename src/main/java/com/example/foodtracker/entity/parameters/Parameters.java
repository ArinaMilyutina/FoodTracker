package com.example.foodtracker.entity.parameters;

import com.example.foodtracker.entity.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
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
    @DecimalMin(value = "0")
    private int age;
    @DecimalMin(value = "0")
    private int height;
    @DecimalMin(value = "0")
    private int weight;
    @Enumerated(EnumType.STRING)
    private ActivityLevel activityLevel;
    @OneToMany(cascade = CascadeType.ALL)
    private List<NormaOfCalories> normaOfCalories;
}
