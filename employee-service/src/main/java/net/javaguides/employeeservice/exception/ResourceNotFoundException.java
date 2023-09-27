package net.javaguides.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String field;
    private Long value;

    public ResourceNotFoundException(String resourceName, String field, Long value) {
        super(String.format("%s not found with %s : '%s'", resourceName, field, value));
        this.resourceName = resourceName;
        this.field = field;
        this.value = value;
    }
}
