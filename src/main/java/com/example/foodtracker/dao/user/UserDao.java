package com.example.foodtracker.dao.user;

import com.example.foodtracker.dao.Dao;
import com.example.foodtracker.entity.Parameters;
import com.example.foodtracker.entity.User;

import java.lang.reflect.Parameter;
import java.util.Optional;

public interface UserDao extends Dao<User> {
    Optional<User> findByUsername (String username);
    Optional<User> findByEmail(String email);
}
