package com.example.finalproject.person.mapper;


import com.example.finalproject.person.dto.UserResponse;
import com.example.finalproject.person.model.Employee;

public class UserMapper {
    public static UserResponse mapToUserDto(Employee employee){
        return new UserResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToUser(UserResponse userDto){
        return new Employee(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
    }

}
