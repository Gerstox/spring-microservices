package com.microservice.management.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.management.persistence.entity.AccountEntity;
import com.microservice.management.persistence.repository.AccountRepository;
import com.microservice.management.service.interfaces.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<AccountEntity> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public AccountEntity findById(String accountId) {
        return accountRepository.findById(accountId).orElseThrow();
    }

    @Override
    public List<AccountEntity> findByClientId(String clientId) {
        return accountRepository.findAllAccountsByClientId(clientId);
    }

    @Override
    public AccountEntity create(AccountEntity account) {
        return accountRepository.save(account);
    }

    @Override
    public AccountEntity update(AccountEntity account) {
        AccountEntity accountDB = findById(account.getId());
        if (accountDB == null) {
            return null;
        }
        
        // TODO: Que no guarde las propiedades nulas
        return accountRepository.save(account);
    }

    @Override
    public AccountEntity delete(String accountId) {
        AccountEntity accountDB = findById(accountId);
        if (accountDB == null) {
            return null;
        }
        accountDB.setStatus(false);
        return accountRepository.save(accountDB);
    }
}
