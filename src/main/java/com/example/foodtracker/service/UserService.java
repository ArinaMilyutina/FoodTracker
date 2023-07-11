package com.example.foodtracker.service;

import com.example.foodtracker.dao.user.UserDao;
import com.example.foodtracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void createUser(User user) {
        userDao.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public String findUser(String username) {

        return userDao.findUser(username);
    }


}
