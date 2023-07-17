package com.example.foodtracker.entity.user;


import com.example.foodtracker.entity.AbstractEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="customers")
public class User extends AbstractEntity {
    private String name;
    private String username;
    private String password;
    private String email;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Parameters parameters;
}
