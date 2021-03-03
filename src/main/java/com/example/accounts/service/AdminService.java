package com.example.accounts.service;

import com.example.accounts.dto.AdminRequestDto;
import com.example.accounts.dto.AdminResponseDto;
import com.example.accounts.dto.EmployeeResponseDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface AdminService extends UserDetailsService {
    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

    AdminResponseDto insertDataIntoAdmin(AdminRequestDto requestDto);

    //AdminResponseDto updateAdmin(String id,AdminRequestDto adminRequestDto);

    AdminResponseDto deleteEmployee(Long id);

    // List<EmployeeResponseDto> getEmployeeList ();
}
