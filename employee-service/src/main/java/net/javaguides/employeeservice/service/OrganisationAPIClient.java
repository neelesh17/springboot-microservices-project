package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.dto.OrganisationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ORGANISATION-SERVICE")
public interface OrganisationAPIClient {
    @GetMapping("api/v1/organisation/{code}")
    OrganisationDto getOrganisation(@PathVariable String code);
}
