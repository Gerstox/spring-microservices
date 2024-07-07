package com.microservice.management.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.management.persistence.entity.AccountEntity;
import com.microservice.management.service.interfaces.IAccountService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/cuentas")
public class AccountController {
    
    @Autowired
    private IAccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountEntity>> findAll() {
        List<AccountEntity> accounts = accountService.findAll();
        if (accounts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountEntity> findById(@PathVariable("accountId") String accountId) {
        AccountEntity account = accountService.findById(accountId);
        if (account == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(account);
    }

    @PostMapping
    public ResponseEntity<AccountEntity> create(@Valid @RequestBody AccountEntity account) {
        AccountEntity newAccount = accountService.create(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<AccountEntity> update(
        @PathVariable("accountId") String accountId,
        @RequestBody AccountEntity account) {

        account.setId(accountId);
        AccountEntity accountDB = accountService.update(account);
        if (accountDB == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(accountDB);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<AccountEntity> delete(@PathVariable("accountId") String accountId) {

        AccountEntity accountDeleted = accountService.delete(accountId);
        if (accountDeleted == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(accountDeleted); 
    }

    @GetMapping("/buscar-por-cliente/{clientId}")
    public ResponseEntity<?> findByClientId(@PathVariable("clientId") String clientId) {
        return ResponseEntity.ok(accountService.findByClientId(clientId));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}