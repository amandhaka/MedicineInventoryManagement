package com.example.accounts.service.impl;

import com.example.accounts.dto.AdminRequestDto;
import com.example.accounts.dto.AdminResponseDto;
import com.example.accounts.dto.EmployeeResponseDto;
import com.example.accounts.entity.Admin;
import com.example.accounts.repository.AdminRepository;
import com.example.accounts.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    public AdminResponseDto insertDataIntoAdmin(AdminRequestDto requestDto) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(requestDto,admin);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // Strength set as 12
        String plainPassword = requestDto.getPassword();
        String encodedPassword = encoder.encode(plainPassword);

        admin.setPassword(encodedPassword);

        Admin savedAdmin = adminRespository.save(admin);
        AdminResponseDto adminResponseDto = new AdminResponseDto();
        BeanUtils.copyProperties(savedAdmin,adminResponseDto);
        return adminResponseDto;
    }

    @Override
    public AdminResponseDto deleteEmployee(Long id) {
        Optional<Admin> adminOptional = adminRespository.findById(id);
        if(adminOptional.isPresent()){
            Admin adminFromDb = adminOptional.get();
            AdminResponseDto adminResponseDto = new AdminResponseDto();
            BeanUtils.copyProperties(adminFromDb,adminResponseDto);
            adminRespository.deleteById(id);
            return adminResponseDto;
        }
        return null;
    }

}
