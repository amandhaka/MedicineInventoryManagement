package com.example.AccountService.repository;

import com.example.AccountService.dto.EmployeeResponseDto;
import com.example.AccountService.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee findByUsername(String username);

    List<Employee> findAll();
}
