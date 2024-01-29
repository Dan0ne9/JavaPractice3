package com.example.finalproject.person.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Также снова нейминг
@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
