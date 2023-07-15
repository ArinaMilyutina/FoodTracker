package com.example.foodtracker.dao.recipe;

import com.example.foodtracker.entity.recipe.Recipe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class HibernateRecipeDao implements RecipeDao {
    private static final String FIND_ALL = "from Recipe";
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Recipe recipe) {
        entityManager.persist(recipe);
    }

    @Override
    public List<Recipe> findAll() {
        return entityManager.createQuery(FIND_ALL, Recipe.class).getResultList();
    }
}
