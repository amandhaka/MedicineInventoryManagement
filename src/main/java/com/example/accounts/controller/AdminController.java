package com.example.accounts.controller;

import com.example.accounts.dto.AdminAuthenticationRequest;
import com.example.accounts.dto.AdminAuthenticationResponse;
import com.example.accounts.dto.AdminRequestDto;
import com.example.accounts.dto.AdminResponseDto;
import com.example.accounts.service.AdminService;
import com.example.accounts.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
public class AdminController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private AdminService adminService;

    @PostMapping("/login-as-admin")
    public AdminAuthenticationResponse generateToken(@RequestBody AdminAuthenticationRequest adminAuthenticationRequest) throws Exception {
        try{
            String encodedPassword = encodePassword(adminAuthenticationRequest.getPassword());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(adminAuthenticationRequest.getUsername(),encodedPassword));
            System.out.println(adminAuthenticationRequest.getPassword());
        } catch (BadCredentialsException ex){
            throw new BadCredentialsException("Invalid Credentials");
        }
        AdminAuthenticationResponse adminAuthenticationResponse = new AdminAuthenticationResponse();
        adminAuthenticationResponse.setJwt(jwtUtil.generateToken(adminAuthenticationRequest.getUsername()));
        return adminAuthenticationResponse;
    }

    @PostMapping("/register-as-admin")
    public AdminResponseDto adminResponseDto (@RequestBody AdminRequestDto adminRequestDto) throws Exception{
        return adminService.insertDataIntoAdmin(adminRequestDto);
    }

//    @PutMapping("/update-employee/{id}" )
//    public AdminResponseDto adminResponseDto (@PathVariable("id") String id, @RequestBody AdminRequestDto adminRequestDto){
//        return adminService.updateAdmin(id,adminRequestDto);
//    }

    @DeleteMapping("/delete-employee/{id}")
    public AdminResponseDto adminResponseDto (@PathVariable("id") Long id){
        return adminService.deleteEmployee(id);
    }

    private String encodePassword (String passwordToHash){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++) {
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
