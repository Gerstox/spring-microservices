package com.microservice.management.web.dto.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.microservice.management.persistence.enumeration.AccountTypeEnum;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateAccountDTO {

    private String accountNumber;
    
    private AccountTypeEnum accountType;

    private Double initialBalance;
}
