package net.javaguides.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "Data transfer object for employee service"
)
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String departmentCode;
    private String organisationCode;
}
