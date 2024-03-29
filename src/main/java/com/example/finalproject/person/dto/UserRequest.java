package com.example.finalproject.person.dto;

import com.example.finalproject.person.model.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String firstName;
    private String lastName;
    private String email;

    public Employee mapToUser(){
        return new Employee(firstName,lastName,email);
    }

}
