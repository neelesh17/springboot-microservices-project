package net.javaguides.employeeservice.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.APIResponseDTO;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.dto.OrganisationDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.exception.ResourceNotFoundException;
import net.javaguides.employeeservice.mapper.AutoEmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.APIClient;
import net.javaguides.employeeservice.service.EmployeeService;
import net.javaguides.employeeservice.service.OrganisationAPIClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.security.PrivilegedAction;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
//    private RestTemplate restTemplate;
//    private WebClient webClient;
    private APIClient apiClient;
    private OrganisationAPIClient organisationAPIClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
//        Employee employee = new Employee(
//                employeeDto.getId(), employeeDto.getFirstName(),
//                employeeDto.getLastName(), employeeDto.getEmail()
//        );
        Employee employee = AutoEmployeeMapper.MAPPER.employeeDtoToEmployee(employeeDto);
        System.out.println(employee);
        Employee savedEmployee = employeeRepository.save(employee);
//        return new EmployeeDto(
//                savedEmployee.getId(), savedEmployee.getFirstName(),
//                savedEmployee.getLastName(), savedEmployee.getEmail()
//        );
        return AutoEmployeeMapper.MAPPER.employeeToEmployeeDto(savedEmployee);
    }

    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );
//  Using rest api template to create a api call to other microservice
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/v1/department/" + employee.getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

//   Using web client to make api call to other micro service
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/v1/department/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

//        OrganisationDto organisationDto = webClient.get()
//                .uri("http://localhost:8083/api/v1/organisation/" + employee.getOrganisationCode())
//                .retrieve()
//                .bodyToMono(OrganisationDto.class)
//                .block();

//        USING PRING OPENFIEGN API CLIENT OT MAKE REST API CALL TO OTHER MICROSERVICE

        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
        OrganisationDto organisationDto = organisationAPIClient.getOrganisation(employee.getOrganisationCode());
//        return new EmployeeDto(
//                employee.getId(), employee.getFirstName(),
//                employee.getLastName(), employee.getEmail()
//        );
        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.employeeToEmployeeDto(employee);
        APIResponseDTO apiResponseDTO = new APIResponseDTO(employeeDto, departmentDto, organisationDto);
        return apiResponseDTO;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> AutoEmployeeMapper.MAPPER.employeeToEmployeeDto(employee)).collect(Collectors.toList());
    }

    public APIResponseDTO getDefaultDepartment(Long employeeId, Exception exception){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );
        DepartmentDto departmentDto = new DepartmentDto((long) 5, "R&D","Research and Development", "RD001");
        OrganisationDto organisationDto = new OrganisationDto((long) 5, "abcd" ,"CLOUD RELATED STUFF","ABDC", LocalDateTime.now());
        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.employeeToEmployeeDto(employee);
        APIResponseDTO apiResponseDTO = new APIResponseDTO(employeeDto, departmentDto, organisationDto);
        System.out.println(exception);
        return apiResponseDTO;
    }
}
