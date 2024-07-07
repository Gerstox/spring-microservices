package com.microservice.management.web.dto.movement;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateMovementDTO {

    @NotNull(message = "movementType is required")
    private String movementType;

    @NotNull(message = "value is required")
    private Double value;

    @NotNull(message = "accountId is required")
    private String accountId;
    
}
