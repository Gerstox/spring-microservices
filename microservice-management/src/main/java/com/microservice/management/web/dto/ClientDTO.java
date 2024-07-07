package com.microservice.management.web.dto;

import com.microservice.management.persistence.enumeration.GenderEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private String id;
    
    private String identification;
    
    private String name;

    private GenderEnum gender;

    private Integer age;

    private String address;

    private String phone;

    private String password;
}