package com.example.foodtracker.controller;

import com.example.foodtracker.dto.LoginDto;
import com.example.foodtracker.dto.ParametersDto;
import com.example.foodtracker.dto.RegistrationDto;
import com.example.foodtracker.entity.NormaOfCalories;
import com.example.foodtracker.entity.Parameters;
import com.example.foodtracker.entity.User;
import com.example.foodtracker.service.ParametersService;
import com.example.foodtracker.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/")
public class UserController {
    private static final String USER = "user";
    private static final String RESULT = "result";
    private static final String PARAMETERS = "parameters";
    private static final String LOGIN_USER = "loginUser";
    private static final String NEW_USER = "newUser";
    private static final String MESSAGE = "message";
    private static final String USER_NOT_FOUND = "User not found !!!";
    private static final String USER_ALREADY_EXISTS = "User already exists !!!";
    private static final String INCORRECT_PASSWORD = "Incorrect password or email!!!";
    private static final String NORMA_CALORIES = "Your daily calorie intake for weight maintenance is ";
    private static final String NORMA_CALORIES_WEIGHT_LOSS = ", for weight loss is ";
    private static final String NORMA_CALORIES_WEIGHT_GAIN = ", for weight gain is ";
    @Autowired
    private UserService userService;
    @Autowired
    private ParametersService parametersService;

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String reg(Model model) {
        model.addAttribute(NEW_USER, new RegistrationDto());
        return "reg";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String reg(@ModelAttribute(NEW_USER) @Valid RegistrationDto registrationDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "reg";
        }
        String findUser = userService.findUser(registrationDto.getUsername());
        if (findUser.equals("false")) {
            User user = User.builder()
                    .name(registrationDto.getName())
                    .username(registrationDto.getUsername())
                    .password(registrationDto.getPassword())
                    .email(registrationDto.getEmail())
                    .build();
            userService.createUser(user);
            return "redirect:/auth";

        }
        model.addAttribute(MESSAGE, USER_ALREADY_EXISTS);
        return "reg";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String auth(Model model) {

        model.addAttribute(LOGIN_USER, new LoginDto());
        return "auth";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String auth(@ModelAttribute(LOGIN_USER) LoginDto loginDto, Model model, HttpSession httpSession) {
        String findUser = userService.findUser(loginDto.getUsername());
        if (findUser.equals("true")) {
            Optional<User> findByUsername = userService.findByUsername(loginDto.getUsername());
            User user = findByUsername.get();
            if (user.getPassword().equals(loginDto.getPassword())) {
                httpSession.setAttribute(USER, user);
                return "redirect:/parameters";
            } else {
                model.addAttribute(MESSAGE, INCORRECT_PASSWORD);

            }
        } else {
            model.addAttribute(MESSAGE, USER_NOT_FOUND);
        }
        return "auth";

    }


    @RequestMapping(value = "/parameters", method = RequestMethod.GET)
    public String parameters(Model model) {
        model.addAttribute(PARAMETERS, new Parameters());
        return "parameters";
    }

    @RequestMapping(value = "/parameters", method = RequestMethod.POST)
    public String parameters(@ModelAttribute(PARAMETERS) Parameters parameters, ParametersDto parametersDto, Model model, BindingResult bindingResult) {
        double normaOfCalories = parametersService.calculateNormaOfCalories(parameters);
        double normaOfCaloriesForWeightLoss = parametersService.calculateNormaOfCaloriesForWeightLoss(parameters);
        double normaOfCaloriesForWeightGain = parametersService.calculateNormaOfCaloriesForWeightGain(parameters);
        NormaOfCalories norma1 = NormaOfCalories.builder().normaOfCalories(normaOfCalories).build();
        NormaOfCalories norma2 = NormaOfCalories.builder().normaOfCaloriesForWeightLoss(normaOfCaloriesForWeightLoss).build();
        NormaOfCalories norma3 = NormaOfCalories.builder().normaOfCaloriesForWeightGain(normaOfCaloriesForWeightGain).build();
        Parameters parameters1 = Parameters.builder()
                .activityLevel(parametersDto.getActivityLevel())
                .age(parametersDto.getAge())
                .height(parametersDto.getHeight())
                .weight(parametersDto.getWeight())
                .normaOfCalories(List.of(norma1, norma2, norma3))
                .build();
        parametersService.createParameters(parameters1);
        model.addAttribute(RESULT, NORMA_CALORIES + normaOfCalories + NORMA_CALORIES_WEIGHT_LOSS + normaOfCaloriesForWeightLoss + NORMA_CALORIES_WEIGHT_GAIN + normaOfCaloriesForWeightGain);

        return "parameters";
    }

}
