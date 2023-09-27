package net.javaguides.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Schema(
        description = "Data transfer object for department service"
)
public class DepartmentDto {
    private Long id;
    @Schema(
            description = "Name of department"
    )
    private String departmentName;
    @Schema(
            description = "Department description"
    )
    private String departmentDescription;
    @Schema(
            description = "Department Code"
    )
    private String departmentCode;
}
