package net.javaguides.organisationservice.repository;

import net.javaguides.organisationservice.dto.OrganisationDto;
import net.javaguides.organisationservice.entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
    Organisation findByOrganisationCode(String organisationCode);
}
