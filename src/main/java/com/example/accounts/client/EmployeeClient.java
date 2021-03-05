package com.example.accounts.client;


import com.example.accounts.dto.EmployeeResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="employeeClient",url="http://127.0.0.1:8082")
public interface EmployeeClient {
    @RequestMapping(method = RequestMethod.GET, path="/get-employee-list")
    List<EmployeeResponseDto> getEmployeeList ();
}

