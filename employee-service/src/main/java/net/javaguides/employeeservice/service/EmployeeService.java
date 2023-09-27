package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.dto.APIResponseDTO;
import net.javaguides.employeeservice.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDTO getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployees();
}
