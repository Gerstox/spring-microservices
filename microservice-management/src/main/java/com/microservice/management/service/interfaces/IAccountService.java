package com.microservice.management.service.interfaces;

import java.util.List;

import com.microservice.management.web.dto.account.AccountDTO;
import com.microservice.management.web.dto.account.CreateAccountDTO;
import com.microservice.management.web.dto.account.UpdateAccountDTO;

public interface IAccountService {
    public List<AccountDTO> findAll();
    public AccountDTO findById(String accountId);
    public List<AccountDTO> findByClientId(String clientId);
    public AccountDTO create(CreateAccountDTO account);
    public AccountDTO update(String accountId, UpdateAccountDTO account);
    public void delete(String accountId);
    public Double updateBalance(String accountId, Double value);
}