package com.example.foodtracker.service;

import com.example.foodtracker.dao.recipe.HibernateRecipeDao;
import com.example.foodtracker.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    @Autowired
    private HibernateRecipeDao hibernateRecipeDao;

    public void createRecipe(Recipe recipe) {
        hibernateRecipeDao.save(recipe);
    }
}
