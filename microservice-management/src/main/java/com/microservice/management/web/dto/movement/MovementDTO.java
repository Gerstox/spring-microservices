package com.microservice.management.web.dto.movement;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovementDTO {

    private String id;

    private LocalDateTime date;

    private String movementType;

    private Double value;

    private Double balance;

    private String account;
}
