package com.example.foodtracker.dao.parameters;

import com.example.foodtracker.dao.Dao;
import com.example.foodtracker.entity.parameters.Parameters;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HibernateParametersDao implements Dao<Parameters> {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void save(Parameters parameters) {
        entityManager.persist(parameters);
    }
}
