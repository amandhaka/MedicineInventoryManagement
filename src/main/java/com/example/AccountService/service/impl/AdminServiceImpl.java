package com.example.AccountService.service.impl;

import com.example.AccountService.entity.Admin;
import com.example.AccountService.repository.AdminRepository;
import com.example.AccountService.service.AdminService;
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
}
