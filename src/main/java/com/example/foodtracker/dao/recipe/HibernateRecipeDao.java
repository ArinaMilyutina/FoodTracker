package com.example.foodtracker.dao.recipe;

import com.example.foodtracker.dao.Dao;
import com.example.foodtracker.entity.Recipe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class HibernateRecipeDao implements Dao<Recipe> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Recipe recipe) {
        entityManager.persist(recipe);
    }

}
