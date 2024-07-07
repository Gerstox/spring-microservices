package com.microservice.management.persistence.projection;

import java.util.Date;

public interface AccountStatusReport {
    String clientName();
    String accountNumber();
    String accountType();
    String initialBalance();
    String availableBalance();
    Boolean accountStatus();
    Double movement();
    Date date();
}
