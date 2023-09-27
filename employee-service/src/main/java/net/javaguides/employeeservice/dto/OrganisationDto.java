package net.javaguides.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "Data transfer object for organisation service"
)
public class OrganisationDto {
    private Long id;
    private String organisationName;
    private String organisationDescription;
    private String organisationCode;
    private LocalDateTime organisationCreatedDate;
}
