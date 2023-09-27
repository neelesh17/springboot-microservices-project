package net.javaguides.organisationservice.mapper;

import net.javaguides.organisationservice.entity.Organisation;
import net.javaguides.organisationservice.dto.OrganisationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface AutoOrganisationMapper {
    AutoOrganisationMapper MAPPER = Mappers.getMapper(AutoOrganisationMapper.class);
    OrganisationDto organisationToOrganisationDto(Organisation organisation);
    Organisation organisationDtoToOrganisation(OrganisationDto organisationDto);
}
