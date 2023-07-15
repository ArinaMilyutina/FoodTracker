package com.example.foodtracker.controller;

import com.example.foodtracker.dto.RecipeDto;
import com.example.foodtracker.entity.recipe.Recipe;
import com.example.foodtracker.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@Controller
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    private static final String RECIPE = "recipe";


    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveRecipe(Model model) {
        model.addAttribute(RECIPE, new RecipeDto());
        return "recipe";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRecipe(@ModelAttribute(RECIPE) RecipeDto recipeDto) throws IOException {
        Recipe recipe = Recipe.builder()
                .description(recipeDto.getDescription())
                .name(recipeDto.getName())
                .image(recipeDto.getMultipartFile().getBytes()).build();
        recipeService.createRecipe(recipe);
        return "recipe";
    }
}
