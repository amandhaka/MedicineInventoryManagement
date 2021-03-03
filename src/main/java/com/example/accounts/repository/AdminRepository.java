package com.example.accounts.repository;

import com.example.accounts.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername (String username);
}

