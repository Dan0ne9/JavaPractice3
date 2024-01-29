package com.example.finalproject.person.service;


import com.example.finalproject.person.dto.UserResponse;
import com.example.finalproject.person.exceptions.UserNotFoundException;
import com.example.finalproject.person.mapper.UserMapper;
import com.example.finalproject.person.model.Employee;
import com.example.finalproject.person.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public Collection<UserResponse> getAllUsers(){
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }
    @Override
    public void savePerson(Employee employee) {
        this.employeeRepository.save(employee);
    }
    @Override
    public Employee getUserById(Long userId) throws UserNotFoundException {
        Optional<Employee> optionalUser = employeeRepository.findById(userId);
        Employee employee = optionalUser.orElseThrow(()->new UserNotFoundException("Пользователь не найден"));
        return employee;
    }

    @Override
    public void deleteUserById(Long userId) {
        this.employeeRepository.deleteById(userId);
    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.employeeRepository.findAll(pageable);
    }


}
