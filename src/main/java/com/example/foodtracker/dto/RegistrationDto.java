package com.example.foodtracker.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {
    @NotBlank
    @Size(min=2,message = "The size of your name should be 5 letters.")
    private String name;
    @Pattern(regexp = "[A-Za-z0-9]+", message = "The username can contain only letters and numbers.")
    private String username;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "The password must consist of 8+ characters, including at least one uppercase, one lowercase letter and one number.")
    private String password;
    @Email(message = "Non-direct email format.")
    private String email;
}
