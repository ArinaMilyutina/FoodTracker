package com.example.foodtracker.service;

import com.example.foodtracker.dao.parameters.HibernateParametersDao;
import com.example.foodtracker.entity.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ParametersService extends NormOfCalories {
    private static final String MESSAGE = "Your norm of calories to maintain weight is equal to ";

    @Autowired
    private HibernateParametersDao hibernateParametersDao;


    public void createParameters(Parameters parameters) {
        hibernateParametersDao.save(parameters);
    }

    public double calculateNormaOfCalories(Parameters parameters) {

        switch (parameters.getActivityLevel()) {
            case "minimum" -> {

                return minimumLevel(parameters.getAge(),parameters.getHeight(),parameters.getWeight());
            }
            case "low" -> {
//                parametersDto.setNorma(lowLevel(parametersDto.getAge(), parametersDto.getHeight(), parametersDto.getWeight()));
//                return parameter;
            }
            case "average" -> {
//                parametersDto.setNorma(averageLevel(parametersDto.getAge(), parametersDto.getHeight(), parametersDto.getWeight()));
//                return parameter;
            }
            case "high" -> {
//                parametersDto.setNorma(highLevel(parametersDto.getAge(), parametersDto.getHeight(), parametersDto.getWeight()));
//                return parameter;
            }
            case "very high" -> {
//                parametersDto.setNorma(veryHighLevel(parametersDto.getAge(), parametersDto.getHeight(), parametersDto.getWeight()));
//                return parameter;
            }
        }
        return 0;

    }

}
