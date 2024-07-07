package com.microservice.management.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.microservice.management.persistence.entity.AccountEntity;
import com.microservice.management.persistence.projection.AccountStatusReport;

import java.util.List;
import java.util.Date;

public interface AccountRepository extends JpaRepository<AccountEntity, String> {

    @Query("SELECT a FROM AccountEntity a WHERE a.clientId = :clientId")
    List<AccountEntity> findAllAccountsByClientId(String clientId);

    List<AccountEntity> findByAccountNumber(String accountNumber);

    @Query(value="""
            SELECT :#{#clientName} as clientName, a.account_number as accountNumber, a.account_type as accountType, a.status as accountStatus,
            DATE_FORMAT(m.date, '%d-%m-%Y') as date, (m.balance - m.value ) as initialBalance, m.value as movement, m.balance as availableBalance
            FROM accounts a
            INNER JOIN movements m ON m.account_id = a.id
            WHERE a.client_id = :#{#clientId} AND m.date BETWEEN :#{#startDate} AND :#{#endDate}
            Order by m.date DESC
            """, nativeQuery = true)
    List<AccountStatusReport> getAccountStatusReport(
        @Param("startDate") Date startDate, 
        @Param("endDate") Date endDate,
        @Param("clientId") String clientId,
        @Param("clientName") String clientName);
}