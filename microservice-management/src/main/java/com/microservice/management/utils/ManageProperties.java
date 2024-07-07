package com.microservice.management.utils;

import com.microservice.management.persistence.entity.AccountEntity;
import com.microservice.management.web.dto.UpdateAccountDTO;

public class ManageProperties {
    public static AccountEntity addProperties(UpdateAccountDTO source, AccountEntity target) {
        if(source.getAccountNumber() != null) {
            target.setAccountNumber(source.getAccountNumber());
        }

        if(source.getAccountType() != null) {
            target.setAccountType(source.getAccountType());
        }

        if(source.getInitialBalance() != null) {
            target.setInitialBalance(source.getInitialBalance());
        }

        return target;
    }
}
