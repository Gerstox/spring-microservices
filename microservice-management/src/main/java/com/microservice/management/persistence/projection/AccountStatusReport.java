package com.microservice.management.persistence.projection;

public interface AccountStatusReport {
    String getClientName();
    String getAccountNumber();
    String getAccountType();
    String getInitialBalance();
    String getAvailableBalance();
    Boolean getAccountStatus();
    Double getMovement();
    String getDate();
}
