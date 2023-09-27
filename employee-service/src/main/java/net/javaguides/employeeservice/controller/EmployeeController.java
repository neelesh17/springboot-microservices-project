package net.javaguides.employeeservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.APIResponseDTO;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@AllArgsConstructor
@Tag(
        name = "Employee Service - Controller",
        description = "It exposes REST APIs for employee Service"
)
public class EmployeeController {
    private EmployeeService employeeService;

    @Operation(
            summary = "Save Employee Rest Api",
            description = "Saves a employee in the mysql database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployeeDto = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Employee Rest Api",
            description = "Gets employee details present in the mysql database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDTO> getEmployeeById(@PathVariable Long id){
        APIResponseDTO APIDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(APIDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Gets All Employee Rest Api",
            description = "Gets a list of all present in the mysql database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }
}
