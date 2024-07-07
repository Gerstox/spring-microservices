package com.microservice.client.web.controller;

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

import com.microservice.client.persistence.entity.ClientEntity;
import com.microservice.client.service.interfaces.IClientService;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientEntity>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.clientService.findAll());
    }
    @GetMapping("/{clientId}")
    public ResponseEntity<ClientEntity> findById(@PathVariable("clientId") String clientId) {
        return ResponseEntity.status(HttpStatus.OK).body(this.clientService.findById(clientId));
    }

    @PostMapping
    public ResponseEntity<ClientEntity> create(@RequestBody ClientEntity client) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.clientService.create(client));
    }
    
    @PutMapping("/{clientId}")
    public ResponseEntity<ClientEntity> update(
        @PathVariable("clientId") String clientId,
        @RequestBody ClientEntity clientData) {
            return ResponseEntity.status(HttpStatus.OK).body(this.clientService.update(clientId, clientData));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> delete(@PathVariable("clientId") String clientId) {
        this.clientService.delete(clientId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/cuentas/{clientId}")
    public ResponseEntity<?> findAccountsByClientId(@PathVariable("clientId") String clientId) {
        return ResponseEntity.ok(clientService.findAccountsByClientId(clientId));
    }
    
}
