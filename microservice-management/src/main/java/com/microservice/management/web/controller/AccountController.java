package com.microservice.management.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.management.service.interfaces.IAccountService;
import com.microservice.management.web.dto.AccountDTO;
import com.microservice.management.web.dto.CreateAccountDTO;
import com.microservice.management.web.dto.UpdateAccountDTO;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class AccountController {
    
    @Autowired
    private IAccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.accountService.findAll());
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDTO> findById(@PathVariable("accountId") String accountId) {
        AccountDTO account = this.accountService.findById(accountId);
        return ResponseEntity.status(HttpStatus.OK).body(account);
    }

    @PostMapping
    public ResponseEntity<AccountDTO> create(@Valid @RequestBody CreateAccountDTO accountDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.accountService.create(accountDTO));
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<AccountDTO> update(
        @PathVariable("accountId") String accountId,
        @RequestBody UpdateAccountDTO accountDTO) {

        return ResponseEntity.status(HttpStatus.OK).body(this.accountService.update(accountId, accountDTO));
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> delete(@PathVariable("accountId") String accountId) {

        this.accountService.delete(accountId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/buscar-por-cliente/{clientId}")
    public ResponseEntity<?> findByClientId(@PathVariable("clientId") String clientId) {
        return ResponseEntity.ok(accountService.findByClientId(clientId));
    }
}