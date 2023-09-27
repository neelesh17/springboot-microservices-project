package net.javaguides.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service Rest API",
				description = "Employee Service Rest API Documentation",
				version = "v1"
		),
		externalDocs = @ExternalDocumentation(
				description = "Employee-Service Docs",
				url="https://www.javaguides.net"
		)
)
public class EmployeeServiceApplication {

	//for using rest template to make api class to other microservices
//	@Bean
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}

	//for configuring web client as spring bean
//	@Bean
//	public WebClient webClient(){
//		return WebClient.builder().build();
//	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
