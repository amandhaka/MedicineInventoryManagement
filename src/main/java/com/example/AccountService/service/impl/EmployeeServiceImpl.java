package com.example.AccountService.service.impl;

import com.example.AccountService.dto.EmployeeRequestDto;
import com.example.AccountService.dto.EmployeeResponseDto;
import com.example.AccountService.entity.Employee;
import com.example.AccountService.repository.EmployeeRepository;
import com.example.AccountService.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Employee employee = employeeRepository.findByUsername(username);
        return new User(employee.getUsername(),employee.getPassword(),new ArrayList<>());

    }

    @Override
    public EmployeeResponseDto insertDataIntoEmployee(EmployeeRequestDto requestDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(requestDto,employee);
        Employee savedAdmin = employeeRepository.save(employee);
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        BeanUtils.copyProperties(savedAdmin,employeeResponseDto);
        return employeeResponseDto;
    }
}
