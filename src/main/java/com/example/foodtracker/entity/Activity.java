package com.example.foodtracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Table(name = "level_activity")
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Activity extends AbstractEntity {
     private String activityLevel;
}
