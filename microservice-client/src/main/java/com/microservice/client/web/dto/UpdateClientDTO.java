package com.microservice.client.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.microservice.client.persistence.enumeration.GenderEnum;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateClientDTO {
    
    private String name;

    private GenderEnum gender;

    private Integer age;

    private String address;

    private String phone;

    private String password;
}