package com.example.foodtracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto {
    @NotBlank
    @Size(min = 2, message = "The size of your name should be 2 letters.")
    private String name;
    @NotBlank
    @Size(min = 2, message = "The size of your description should be 1 letters.")
    private String description;
    private MultipartFile multipartFile;
}
