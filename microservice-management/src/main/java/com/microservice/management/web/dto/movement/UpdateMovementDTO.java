package com.microservice.management.web.dto.movement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateMovementDTO {

    private String movementType;

    private Double value;

    private Double balance;
}
