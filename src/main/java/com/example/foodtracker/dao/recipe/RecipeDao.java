package com.example.foodtracker.dao.recipe;

import com.example.foodtracker.dao.Dao;
import com.example.foodtracker.entity.recipe.Recipe;

import java.util.List;

public interface RecipeDao extends Dao<Recipe> {
    List<Recipe> findAll();
}
