package net.javaguides.organisationservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.javaguides.organisationservice.dto.OrganisationDto;
import net.javaguides.organisationservice.service.OrganisationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/organisation")
@AllArgsConstructor
@Tag(
        name = "Organisation Service - Controller",
        description = "It exposes REST APIs for organisation Service"
)
public class OrganisationController {
    private OrganisationService organisationService;

    @Operation(
            summary = "Save Organisation Rest Api",
            description = "Saves a organisation in the mysql database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    @PostMapping("")
    public ResponseEntity<OrganisationDto> saveOrganisation(@RequestBody OrganisationDto organisationDto){
        OrganisationDto saveOrganisation = organisationService.saveOrganisation(organisationDto);
        return new ResponseEntity<>(saveOrganisation, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get Organisation Rest Api",
            description = "Gets a organisation in the mysql database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @GetMapping("{code}")
    public ResponseEntity<OrganisationDto> getOrganisationByCode(@PathVariable String code){
        OrganisationDto organisationDto = organisationService.getOrganisationByCode(code);
        return new ResponseEntity<>(organisationDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Gets All Organisation Rest Api",
            description = "Gets all organisation in the mysql database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @GetMapping
    public ResponseEntity<List<OrganisationDto>> getAllOrganisations(){
        List<OrganisationDto> organisationDtos = organisationService.getAllOrganisations();
        return new ResponseEntity<>(organisationDtos, HttpStatus.OK);
    }
}
