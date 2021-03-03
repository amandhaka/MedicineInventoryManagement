package com.example.AccountService.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AdminService extends AuthUserService  {
    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
