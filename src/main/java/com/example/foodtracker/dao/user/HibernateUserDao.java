package com.example.foodtracker.dao.user;


import com.example.foodtracker.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class HibernateUserDao implements UserDao {
    private static final String FIND_BY_USER_NAME = "from User where username = :username";
    private static final String USERNAME = "username";
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findByUserName(String username) {
        return entityManager.createQuery(FIND_BY_USER_NAME, User.class)
                .setParameter(USERNAME, username)
                .getSingleResult();
    }
}
