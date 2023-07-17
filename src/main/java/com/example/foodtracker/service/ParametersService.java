package com.example.foodtracker.service;

import com.example.foodtracker.dao.parameters.HibernateParametersDao;
import com.example.foodtracker.dto.ParametersDto;
import com.example.foodtracker.entity.user.Parameters;
import com.example.foodtracker.util.CalorieCounterForUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ParametersService {

    @Autowired
    private HibernateParametersDao hibernateParametersDao;
    @Autowired
    private CalorieCounterForUserUtil calorieCounter;


    public void createParameters(Parameters parameters) {
        hibernateParametersDao.save(parameters);
    }


    public double calculateNormaOfCalories(ParametersDto parameters) {
        return calorieCounter.calculateNormaOfCalories(parameters);
    }

    public double calculateNormaOfCaloriesForWeightLoss(ParametersDto parameters) {
        return calorieCounter.calculateNormaOfCaloriesForWeightLoss(parameters);
    }

    public double calculateNormaOfCaloriesForWeightGain(ParametersDto parameters) {
        return calorieCounter.calculateNormaOfCaloriesForWeightGain(parameters);
    }

}
