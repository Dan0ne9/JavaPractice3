package com.example.finalproject.person.mapper;

import com.example.finalproject.person.dto.UserResponse;
import com.example.finalproject.person.model.Employee;
import org.springframework.stereotype.Service;


/**
 * Пример реализации того, что я имел ввиду под выделение этого UserMapper в отдельный класс-сервис
 */
//@Service
//public class UserMapperService {
//
//    //Если уж метод возвращает UserResponse, то и на вход он должен принимать User, а не Employee
//    public UserResponse mapToUserDto(Employee employee) {
//        return new UserResponse(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail()
//        );
//    }
//
//    //Тоже самое здесь
//    public Employee mapToUser(UserResponse userDto) {
//        return new Employee(
//                userDto.getId(),
//                userDto.getFirstName(),
//                userDto.getLastName(),
//                userDto.getEmail()
//        );
//    }
//
//}
