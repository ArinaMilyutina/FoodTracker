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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/user")
public class UserController {
    private static final String USER = "user";
    private static final String RESULT = "result";
    private static final String PARAMETERS = "parameters";
    private static final String LOGIN_USER = "loginUser";
    private static final String NEW_USER = "newUser";
    private static final String MESSAGE = "message";
    private static final String USER_NOT_FOUND = "User not found !!!";
    private static final String INCORRECT_PASSWORD = "Incorrect password !!!";
    private static final String NORMA_CALORIES = "Your daily calorie intake for weight maintenance is ";
    private static final String NORMA_CALORIES_WEIGHT_LOSS = ", for weight loss is ";
    private static final String NORMA_CALORIES_WEIGHT_GAIN = ", for weight gain is ";
    @Autowired
    private UserService userService;
    @Autowired
    private ParametersService parametersService;

    @GetMapping("/reg")
    public String reg(Model model) {
        model.addAttribute(NEW_USER, new RegistrationDto());
        return "reg";
    }

    @PostMapping("/reg")
    public String reg(@ModelAttribute(NEW_USER) @Valid RegistrationDto registrationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reg";
        }
        User user = User.builder()
                .name(registrationDto.getName())
                .username(registrationDto.getUsername())
                .password(registrationDto.getPassword())
                .email(registrationDto.getEmail())
                .build();
        userService.createUser(user);
        return "redirect:/user/auth";

    }

    @GetMapping("/auth")
    public String auth(Model model) {
        model.addAttribute(LOGIN_USER, new LoginDto());
        return "auth";
    }

    @PostMapping("/auth")
    public String auth(@ModelAttribute(LOGIN_USER) LoginDto loginDto, Model model, HttpSession httpSession) {
        Optional<User> findByUsername = userService.findByUsername(loginDto.getUsername());
        if (findByUsername.isPresent()) {

            User user = findByUsername.get();
            if (user.getPassword().equals(loginDto.getPassword())) {
                httpSession.setAttribute(USER, user);
                return "redirect:/user/parameters";
            } else {
                model.addAttribute(MESSAGE, INCORRECT_PASSWORD);

            }
        } else {
            model.addAttribute(MESSAGE, USER_NOT_FOUND);
        }
        return "auth";

    }

    @GetMapping("/parameters")
    public String parameters(Model model) {
        model.addAttribute(PARAMETERS, new Parameters());
        return "parameters";
    }

    @PostMapping("/parameters")
    public String parameters(@ModelAttribute(PARAMETERS) @Valid Parameters parameters, ParametersDto parametersDto, Model model) {
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
