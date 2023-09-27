package net.javaguides.organisationservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.organisationservice.dto.OrganisationDto;
import net.javaguides.organisationservice.entity.Organisation;
import net.javaguides.organisationservice.mapper.AutoOrganisationMapper;
import net.javaguides.organisationservice.repository.OrganisationRepository;
import net.javaguides.organisationservice.service.OrganisationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrganisationServiceImpl implements OrganisationService {
    private OrganisationRepository organisationRepository;

    public OrganisationDto saveOrganisation(OrganisationDto organisationDto){
        Organisation organisation = AutoOrganisationMapper.MAPPER.organisationDtoToOrganisation(organisationDto);
        Organisation savedOrganisation = organisationRepository.save(organisation);
        return AutoOrganisationMapper.MAPPER.organisationToOrganisationDto(savedOrganisation);
    }

    @Override
    public OrganisationDto getOrganisationByCode(String code) {
        Organisation organisation = organisationRepository.findByOrganisationCode(code);
        return AutoOrganisationMapper.MAPPER.organisationToOrganisationDto(organisation);
    }

    @Override
    public List<OrganisationDto> getAllOrganisations() {
        List<Organisation> organisations = organisationRepository.findAll();
        return organisations.stream().map((organisation) -> AutoOrganisationMapper.MAPPER.organisationToOrganisationDto(organisation)).collect(Collectors.toList());
    }

}
