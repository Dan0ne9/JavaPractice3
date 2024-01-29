package com.example.finalproject.person.service;

import com.example.finalproject.person.dto.UserRegistrationDto;
import com.example.finalproject.person.model.User;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
