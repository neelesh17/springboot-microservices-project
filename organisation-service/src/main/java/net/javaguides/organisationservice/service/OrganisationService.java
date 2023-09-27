package net.javaguides.organisationservice.service;


import net.javaguides.organisationservice.dto.OrganisationDto;

import java.util.List;

public interface OrganisationService {

    OrganisationDto saveOrganisation(OrganisationDto organisationDto);
    OrganisationDto getOrganisationByCode(String code);

    List<OrganisationDto> getAllOrganisations();
}
