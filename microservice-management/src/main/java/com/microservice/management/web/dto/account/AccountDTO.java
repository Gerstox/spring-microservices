package com.microservice.management.web.dto.account;

import com.microservice.management.persistence.enumeration.AccountTypeEnum;

import lombok.Data;

@Data
public class AccountDTO {

    private String id;

    private String accountNumber;

    private AccountTypeEnum accountType;

    private Double initialBalance;

    private Boolean status;

    private String clientId;
}
