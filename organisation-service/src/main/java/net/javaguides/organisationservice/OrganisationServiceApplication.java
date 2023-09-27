package net.javaguides.organisationservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Organisation Service Rest API",
				description = "Organisation Service Rest API Documentation",
				version = "v1"
		),
		externalDocs = @ExternalDocumentation(
				description = "Organisation-Service Docs",
				url="https://www.javaguides.net"
		)
)
public class OrganisationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganisationServiceApplication.class, args);
	}

}
