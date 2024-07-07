package com.microservice.management.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.management.network.ClientClient;
import com.microservice.management.persistence.entity.AccountEntity;
import com.microservice.management.persistence.repository.AccountRepository;
import com.microservice.management.service.exceptions.InsufficientFundsException;
import com.microservice.management.service.interfaces.IAccountService;
import com.microservice.management.utils.ManageProperties;
import com.microservice.management.web.dto.account.AccountDTO;
import com.microservice.management.web.dto.account.CreateAccountDTO;
import com.microservice.management.web.dto.account.UpdateAccountDTO;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClientClient clientClient;

    @Override
    public List<AccountDTO> findAll() {
        List<AccountEntity> accounts = accountRepository.findAll();
        return accounts.stream().map(account -> this.modelMapper.map(account, AccountDTO.class)).collect(Collectors.toList());
    }

    @Override
    public AccountDTO findById(String accountId) {
        AccountEntity account = this.accountRepository.findById(accountId).orElseThrow(() -> new EntityNotFoundException("Account not found"));
        return this.modelMapper.map(account, AccountDTO.class);
    }

    @Override
    public List<AccountDTO> findByClientId(String clientId) {

        List<AccountEntity> accounts = this.accountRepository.findAllAccountsByClientId(clientId);
        return accounts.stream().map(account -> this.modelMapper.map(account, AccountDTO.class)).collect(Collectors.toList());
    }

    @Override
    public AccountDTO create(CreateAccountDTO accountDTO) {

        this.clientClient.findById(accountDTO.getClientId());
        AccountEntity accountEntity = this.modelMapper.map(accountDTO, AccountEntity.class);
        accountEntity.setStatus(true);
        this.accountRepository.save(accountEntity);
        return this.modelMapper.map(accountEntity, AccountDTO.class);
    }

    @Override
    public AccountDTO update(String accountId, UpdateAccountDTO accountDTO) {

        AccountEntity accountEntity = this.accountRepository.findById(accountId).orElseThrow(() -> new EntityNotFoundException("Client not found"));
        accountEntity = ManageProperties.addAccountProperties(accountDTO, accountEntity);
        AccountEntity updatedAccount = this.accountRepository.save(accountEntity);
        return this.modelMapper.map(updatedAccount, AccountDTO.class);
    }

    @Override
    public void delete(String accountId) {

        AccountEntity account = this.accountRepository.findById(accountId).orElseThrow(() -> new EntityNotFoundException("Account not found"));
        account.setStatus(false);
        this.accountRepository.save(account);
    }

    @Override
    public Double updateBalance(String accountId, Double value) {
        AccountEntity account = this.accountRepository.findById(accountId).orElseThrow(() -> new EntityNotFoundException("Account not found"));
        Double finalAmount = account.getInitialBalance() + value;

        if ( finalAmount < 0) {
            throw new InsufficientFundsException();
        }

        account.setInitialBalance(finalAmount);
        this.accountRepository.save(account);

        return finalAmount;
    }
}
