package com.microservice.client.web.dto;

import com.microservice.client.persistence.enumeration.GenderEnum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateClientDTO {
    
    @NotNull(message = "identification is required")
    private String identification;
    
    @NotNull(message = "name is required")
    private String name;

    private GenderEnum gender;

    private Integer age;

    @NotBlank(message = "address is required")
    private String address;

    @NotBlank(message = "phone is required")
    private String phone;

    @NotBlank(message = "password is required")
    private String password;
}