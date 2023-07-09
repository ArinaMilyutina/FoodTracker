package com.example.foodtracker.controller;

import com.example.foodtracker.dto.LoginDto;
import com.example.foodtracker.dto.RegistrationDto;
import com.example.foodtracker.entity.User;
import com.example.foodtracker.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


@Controller
@RequestMapping("/user")
public class UserController {
    private static final String USER = "user";
    private static final String LOGIN_USER = "loginUser";
    private static final String NEW_USER = "newUser";
    private static final String MESSAGE = "message";
    private static final String USER_NOT_FOUND = "User not found !!!";
    private static final String INCORRECT_PASSWORD = "Incorrect password !!!";
    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String reg(Model model) {
        model.addAttribute(NEW_USER, new RegistrationDto());
        return "reg";
    }

    @PostMapping("/reg")
    public String reg(@ModelAttribute(NEW_USER) RegistrationDto registrationDto) {
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
                return "redirect:/user/req";
            } else {
                model.addAttribute(MESSAGE, INCORRECT_PASSWORD);

            }
        } else {
            model.addAttribute(MESSAGE, USER_NOT_FOUND);
        }
        return "auth";

    }

}
