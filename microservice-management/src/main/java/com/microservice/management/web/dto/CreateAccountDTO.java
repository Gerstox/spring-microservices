package com.microservice.management.web.dto;

import com.microservice.management.persistence.enumeration.AccountTypeEnum;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateAccountDTO {

    @NotNull(message = "accountNumber is required")
    private String accountNumber;
    
    @NotNull(message = "accountType is required")
    private AccountTypeEnum accountType;

    @NotNull(message = "initialBalance is required")
    private Double initialBalance;

    @NotNull(message = "clientId is required")
    private String clientId;
    
}
