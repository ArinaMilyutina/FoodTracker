package com.example.foodtracker.dao.product;

import com.example.foodtracker.dao.Dao;
import com.example.foodtracker.entity.product.NewProduct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HibernateNewProductDao implements Dao<NewProduct> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(NewProduct newProduct) {
        entityManager.persist(newProduct);
    }
}
