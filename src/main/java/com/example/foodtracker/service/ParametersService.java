package com.example.foodtracker.service;

import com.example.foodtracker.dao.parameters.HibernateParametersDao;
import com.example.foodtracker.entity.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ParametersService {

    @Autowired
    private HibernateParametersDao hibernateParametersDao;
    @Autowired
    private CalorieCounter calorieCounter;


    public void createParameters(Parameters parameters) {
        hibernateParametersDao.save(parameters);
    }


    public double calculateNormaOfCalories(Parameters parameters) {
        return calorieCounter.calculateNormaOfCalories(parameters);
    }

    public double calculateNormaOfCaloriesForWeightLoss(Parameters parameters) {
        return calorieCounter.calculateNormaOfCaloriesForWeightLoss(parameters);
    }

    public double calculateNormaOfCaloriesForWeightGain(Parameters parameters) {
        return calorieCounter.calculateNormaOfCaloriesForWeightGain(parameters);
    }

}
