package com.example.AccountService.dto;

import lombok.Data;

@Data
public class EmployeeAuthenticationRequest {

    private String username;
    private String password;
}
