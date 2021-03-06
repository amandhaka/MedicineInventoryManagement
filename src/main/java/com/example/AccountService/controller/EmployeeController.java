package com.example.AccountService.controller;

import com.example.AccountService.dto.EmployeeAuthenticationRequest;
import com.example.AccountService.dto.EmployeeAuthenticationResponse;
import com.example.AccountService.dto.EmployeeRequestDto;
import com.example.AccountService.dto.EmployeeResponseDto;
import com.example.AccountService.service.EmployeeService;
import com.example.AccountService.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private EmployeeService employeeService;

    @CrossOrigin
    @PostMapping("/login-as-employee")
    public EmployeeAuthenticationResponse generateToken(@RequestBody EmployeeAuthenticationRequest employeeAuthenticationRequest) throws BadCredentialsException{
        try{
            String encodedPassword = encodePassword(employeeAuthenticationRequest.getPassword());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(employeeAuthenticationRequest.getUsername(), encodedPassword));
        } catch (BadCredentialsException ex) {
            throw new BadCredentialsException("Invalid");
        }
        EmployeeAuthenticationResponse employeeAuthenticationResponse = new EmployeeAuthenticationResponse();
        employeeAuthenticationResponse.setJwt(jwtUtil.generateToken(employeeAuthenticationRequest.getUsername()));
        return employeeAuthenticationResponse;
    }
    @CrossOrigin
    @PostMapping("/register-as-employee")
    public EmployeeResponseDto employeeResponseDto(@RequestBody EmployeeRequestDto requestDto){
        return employeeService.insertDataIntoEmployee(requestDto);
    }

    @CrossOrigin
    @GetMapping("/get-employee-list")
    public List<EmployeeResponseDto> employeeResponseDto() {
        return employeeService.getEmployeeList();
    }

    private String encodePassword (String passwordToHash){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
