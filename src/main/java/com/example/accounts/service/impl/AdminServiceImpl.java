package com.example.accounts.service.impl;

import com.example.accounts.dto.AdminRequestDto;
import com.example.accounts.dto.AdminResponseDto;
import com.example.accounts.entity.Admin;
import com.example.accounts.repository.AdminRepository;
import com.example.accounts.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRespository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin=adminRespository.findByUsername(username);
        return new User(admin.getUsername(), admin.getPassword(), new ArrayList<>());
    }

    @Override
    public AdminResponseDto insertDataIntoAdmin(AdminRequestDto requestDto) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(requestDto,admin);
        Admin savedAdmin = adminRespository.save(admin);
        AdminResponseDto adminResponseDto = new AdminResponseDto();
        BeanUtils.copyProperties(savedAdmin,adminResponseDto);
        return adminResponseDto;
    }
}
