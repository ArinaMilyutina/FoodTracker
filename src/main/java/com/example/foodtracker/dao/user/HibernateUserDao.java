package com.example.foodtracker.dao.user;


import com.example.foodtracker.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class HibernateUserDao implements UserDao {
    private static final String FIND_BY_USERNAME = "from User where username = :username";

    private static final String FIND_BY_EMAIL = "from User where email = :email";
    private static final String FIND_BOOLEAN_USER = "select distinct case when count(*) > 0  then 'true'  else 'false' end from User where username = :username";
    private static final String USERNAME = "username";
    private static final String EMAIL = "email";
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.of(entityManager.createQuery(FIND_BY_USERNAME, User.class)
                .setParameter(USERNAME, username)
                .getSingleResult());
    }


    public String findUser(String username) {
        return entityManager.createQuery(FIND_BOOLEAN_USER, String.class)
                .setParameter(USERNAME, username)
                .getSingleResult();
    }
}
