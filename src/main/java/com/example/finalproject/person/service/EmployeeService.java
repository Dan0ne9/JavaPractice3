package com.example.finalproject.person.service;

import com.example.finalproject.person.dto.UserResponse;
import com.example.finalproject.person.exceptions.UserNotFoundException;
import com.example.finalproject.person.model.Employee;
import org.springframework.data.domain.Page;

import java.util.Collection;


public interface EmployeeService {
    Collection<UserResponse> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(Long userId) throws UserNotFoundException;
    void deleteEmployeeById(Long userId);

    Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
