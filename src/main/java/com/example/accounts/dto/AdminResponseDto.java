package com.example.accounts.dto;

import lombok.Data;

@Data
public class AdminResponseDto {
    private Long id;
    private String username;
    private String password;
    private String name;
}
