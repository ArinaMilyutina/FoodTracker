package com.example.foodtracker.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="customers")
public class User extends AbstractEntity{
    private String name;
    private String username;
    private String password;
    private String email;
    private Parameters parameters;

}
