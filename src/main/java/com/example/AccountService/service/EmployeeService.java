package com.example.AccountService.service;

import com.example.AccountService.dto.EmployeeRequestDto;
import com.example.AccountService.dto.EmployeeResponseDto;
import org.apache.catalina.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface EmployeeService extends UserDetailsService {

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

    EmployeeResponseDto insertDataIntoEmployee(EmployeeRequestDto requestDto);
}
