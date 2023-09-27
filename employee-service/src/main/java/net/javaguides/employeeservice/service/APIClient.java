package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//IF not using eureka service
//@FeignClient(url = "http://localhost:8080/api/v1/department/", value = "DEPARTMENT-SERVICE")

//IF USING EREKA SERVICE WE PASS THE APPLICATON NAME SO THAT EUREKA CAN USE LOAD BALANCING WHEN NECESSARY
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/v1/department/{code}")
    DepartmentDto getDepartment(@PathVariable String code);
}
