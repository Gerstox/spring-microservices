package com.microservice.management.utils;

import com.microservice.management.persistence.entity.AccountEntity;
import com.microservice.management.persistence.entity.MovementEntity;
import com.microservice.management.web.dto.account.UpdateAccountDTO;
import com.microservice.management.web.dto.movement.UpdateMovementDTO;

public class ManageProperties {
    public static AccountEntity addAccountProperties(UpdateAccountDTO source, AccountEntity target) {
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

    public static MovementEntity addMovementProperties(UpdateMovementDTO source, MovementEntity target) {
        if(source.getMovementType() != null) {
            target.setMovementType(source.getMovementType());
        }

        if(source.getValue() != null) {
            target.setValue(source.getValue());
        }

        if(source.getBalance() != null) {
            target.setBalance(source.getBalance());
        }

        return target;
    }
}
