package com.microservice.management.service.interfaces;

import java.util.List;

import com.microservice.management.persistence.entity.AccountEntity;

public interface IAccountService {
    public List<AccountEntity> findAll();
    public AccountEntity findById(String accountId);
    public List<AccountEntity> findByClientId(String clientId);
    public AccountEntity create(AccountEntity account);
    public AccountEntity update(AccountEntity account);
    public AccountEntity delete(String accountId);
}