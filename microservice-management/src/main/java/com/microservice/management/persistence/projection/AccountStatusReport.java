package com.microservice.management.persistence.projection;

import java.util.Date;

public interface AccountStatusReport {
    String getClientName();
    String getAccountNumber();
    String getAccountType();
    String getInitialBalance();
    String getAvailableBalance();
    Boolean getAccountStatus();
    Double getMovement();
    Date getDate();
}
