package com.example.accounts.service.impl;

import com.example.accounts.dto.AdminRequestDto;
import com.example.accounts.dto.AdminResponseDto;
import com.example.accounts.dto.EmployeeResponseDto;
import com.example.accounts.entity.Admin;
import com.example.accounts.repository.AdminRepository;
import com.example.accounts.service.AdminService;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sun.security.util.Password;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRespository;


//    @Autowired
//    private EmployeeClient employeeClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin=adminRespository.findByUsername(username);
        return new User(admin.getUsername(), admin.getPassword(), new ArrayList<>());
    }

//    @Override
//    public List<EmployeeResponseDto> getEmployeeList() {
//        List<EmployeeResponseDto> employeeList = employeeClient.getEmployeeList();
//        return employeeList;
//    }

    @Override
    public AdminResponseDto insertDataIntoAdmin(AdminRequestDto requestDto) throws Exception {
        Admin admin = new Admin();
        BeanUtils.copyProperties(requestDto,admin);
        String encodedPassword = encodePassword(requestDto.getPassword());
        admin.setPassword(encodedPassword);
        Admin savedAdmin = adminRespository.save(admin);
        AdminResponseDto adminResponseDto = new AdminResponseDto();
        BeanUtils.copyProperties(savedAdmin,adminResponseDto);
        return adminResponseDto;
    }

    @Override
    public AdminResponseDto deleteEmployee(Long id) {
        Optional<Admin> adminOptional = adminRespository.findById(id);
        if (adminOptional.isPresent()) {
            Admin adminFromDb = adminOptional.get();
            AdminResponseDto adminResponseDto = new AdminResponseDto();
            BeanUtils.copyProperties(adminFromDb, adminResponseDto);
            adminRespository.deleteById(id);
            return adminResponseDto;
        }
        return null;
    }
    private String encodePassword (String passwordToHash){
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }

}
