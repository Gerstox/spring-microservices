package com.microservice.management.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microservice.management.persistence.entity.AccountEntity;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {

    @Query("SELECT a FROM AccountEntity a WHERE a.clientId = :clientId")
    List<AccountEntity> findAllAccountsByClientId(String clientId);

    // List<AccountEntity> findAllByClientIdList(String clientId);

    List<AccountEntity> findByAccountNumber(String accountNumber);
}