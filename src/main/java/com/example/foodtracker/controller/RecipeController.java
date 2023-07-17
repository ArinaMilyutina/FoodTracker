package com.example.foodtracker.controller;

import com.example.foodtracker.dto.RecipeDto;
import com.example.foodtracker.entity.recipe.Recipe;
import com.example.foodtracker.service.RecipeService;
import com.example.foodtracker.util.Base64ImageConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    private static final String RECIPE = "recipes";
    private static final String BASE_64 = "base64ImageConverter";
    private static final String CREATE_RECIPE = "createRecipe";


    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveRecipe(Model model) {
        model.addAttribute(CREATE_RECIPE, new RecipeDto());
        return "recipe";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRecipe(@ModelAttribute(CREATE_RECIPE) RecipeDto recipeDto, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "recipe";
        }
        Recipe recipe = Recipe.builder()
                .description(recipeDto.getDescription())
                .name(recipeDto.getName())
                .image(recipeDto.getMultipartFile().getBytes()).build();
        recipeService.createRecipe(recipe);
        return "recipe";
    }

    @GetMapping("/recipes")
    public String getAllRecipes(Model model) {
        List<Recipe> recipes = recipeService.findAll();
        model.addAttribute(RECIPE, recipes);
        model.addAttribute(BASE_64, new Base64ImageConverterUtil());
        return "recipes";
    }

}
