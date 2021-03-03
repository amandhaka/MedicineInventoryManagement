package com.example.AccountService.repository;

import com.example.AccountService.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername (String username);
}
