package com.example.finalproject.person.service;

import com.example.finalproject.person.dto.UserResponse;
import com.example.finalproject.person.exceptions.UserNotFoundException;
import com.example.finalproject.person.model.Employee;
import org.springframework.data.domain.Page;

import java.util.Collection;


/**
 * Траблы с неймингом - все методы названы некорректно. Если мы работаем с Employee - то и называться должно
 * getAllEmployees, saveEmployee, getEmployeeById и т.д.
 * Лучше выработать эту привычку сразу - код становится более читабельным и логически понятным,
 * как минимум для тебя самого, не говоря уже о людях которым это дебажить и проверять
 */
public interface EmployeeService {
    Collection<UserResponse> getAllUsers();

    void savePerson(Employee employee);
    Employee getUserById(Long userId) throws UserNotFoundException;
    void deleteUserById(Long userId);

    Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
