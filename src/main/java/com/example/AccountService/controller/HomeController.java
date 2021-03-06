package com.example.AccountService.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @CrossOrigin
    @GetMapping("/")
    public String welcome(){
        return "You are logged in";
    }
}
