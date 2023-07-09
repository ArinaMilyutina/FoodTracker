package com.example.foodtracker.service;

import com.example.foodtracker.dao.user.UserDao;
import com.example.foodtracker.entity.ActivityLevel;
import com.example.foodtracker.entity.Parameters;
import com.example.foodtracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService extends NormOfCalories {
    @Autowired
    private UserDao userDao;

    public void createUser(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public Optional<String> calculateNormaOfCalories(ActivityLevel activityLevel, Parameters parameter) {

        switch (activityLevel.getActivityLevel()) {
            case "minimum" -> {
                parameter.setNorma(minimumLevel(parameter.getAge(), parameter.getHeight(), parameter.getWeight()));
                return Optional.of("Your norm of calories to maintain weight is equal to " + parameter);
            }
            case "low" -> {
                parameter.setNorma(lowLevel(parameter.getAge(), parameter.getHeight(), parameter.getWeight()));
                return Optional.of("Your norm of calories to maintain weight is equal to " + parameter);
            }
            case "average" -> {
                parameter.setNorma(averageLevel(parameter.getAge(), parameter.getHeight(), parameter.getWeight()));
                return Optional.of("Your norm of calories to maintain weight is equal to " + parameter);
            }
            case "high" -> {
                parameter.setNorma(highLevel(parameter.getAge(), parameter.getHeight(), parameter.getWeight()));
                return Optional.of("Your norm of calories to maintain weight is equal to " + parameter);
            }
            case "very high" -> {
                parameter.setNorma(veryHighLevel(parameter.getAge(), parameter.getHeight(), parameter.getWeight()));
                return Optional.of("Your norm of calories to maintain weight is equal to " + parameter);
            }
        }
        return Optional.empty();

    }


}
