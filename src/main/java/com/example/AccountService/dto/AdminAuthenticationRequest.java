package com.example.AccountService.dto;


import lombok.Data;

@Data
public class AdminAuthenticationRequest {
    private String username;
    private String password;
}
