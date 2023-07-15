package com.example.foodtracker.service;

import com.example.foodtracker.dao.recipe.RecipeDao;
import com.example.foodtracker.entity.recipe.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeDao recipeDao;

    public void createRecipe(Recipe recipe) {
        recipeDao.save(recipe);
    }

    public List<Recipe> findAll() {
        return recipeDao.findAll();
    }

}
