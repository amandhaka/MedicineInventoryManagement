package com.example.AccountService.repository;

import com.example.AccountService.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee findByUsername(String username);
}
