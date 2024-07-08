package com.microservice.client.web.dto;

import com.microservice.client.persistence.enumeration.GenderEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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