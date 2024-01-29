package com.example.finalproject.person.controller;

import com.example.finalproject.person.dto.UserRegistrationDto;
import com.example.finalproject.person.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
@AllArgsConstructor
public class UserRegistrationController {

    private final UserService userService;

    @ModelAttribute("userP")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("userP") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        // Можно выводить уведомление, а можно сразу редиректить на страничку логина - в большинстве сайтов и сервисов сделано именно так (хотя это уже придирки)
        return "redirect:/registration?success";
    }
}
