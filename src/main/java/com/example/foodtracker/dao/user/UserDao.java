package com.example.foodtracker.dao.user;

import com.example.foodtracker.dao.Dao;
import com.example.foodtracker.entity.User;

public interface UserDao extends Dao<User> {
    User findByUserName(String username);
}
