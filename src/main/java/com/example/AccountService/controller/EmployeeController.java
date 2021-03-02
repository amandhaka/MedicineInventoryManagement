package com.example.AccountService.controller;

import com.example.AccountService.dto.EmployeeAuthenticationRequest;
import com.example.AccountService.dto.EmployeeAuthenticationResponse;
import com.example.AccountService.util.JwtUtil;
import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public EmployeeAuthenticationResponse generateToken(@RequestBody EmployeeAuthenticationRequest employeeAuthenticationRequest) throws BadCredentialsException{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(employeeAuthenticationRequest.getUsername(), employeeAuthenticationRequest.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new BadCredentialsException("Invalid");
        }
        EmployeeAuthenticationResponse employeeAuthenticationResponse = new EmployeeAuthenticationResponse();
        employeeAuthenticationResponse.setJwt(jwtUtil.generateToken(employeeAuthenticationRequest.getUsername()));
        return employeeAuthenticationResponse;
    }

}
