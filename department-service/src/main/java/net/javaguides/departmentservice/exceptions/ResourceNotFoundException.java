package net.javaguides.departmentservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String field;
    private String value;

    public ResourceNotFoundException(String resourceName, String field, String value) {
        super(String.format("%s not found for %s : '%s'", resourceName, field, value));
        this.resourceName = resourceName;
        this.field = field;
        this.value = value;
    }
}
