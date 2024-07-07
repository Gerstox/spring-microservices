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

import com.microservice.client.service.interfaces.IClientService;
import com.microservice.client.web.dto.ClientDTO;
import com.microservice.client.web.dto.CreateClientDTO;
import com.microservice.client.web.dto.UpdateClientDTO;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.clientService.findAll());
    }
    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDTO> findById(@PathVariable("clientId") String clientId) {
        ClientDTO client = this.clientService.findById(clientId);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> create(@Valid @RequestBody CreateClientDTO clientDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.clientService.create(clientDTO));
    }
    
    @PutMapping("/{clientId}")
    public ResponseEntity<ClientDTO> update(
        @PathVariable("clientId") String clientId,
        @RequestBody UpdateClientDTO clientDTO) {
            return ResponseEntity.status(HttpStatus.OK).body(this.clientService.update(clientId, clientDTO));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> delete(@PathVariable("clientId") String clientId) {
        this.clientService.delete(clientId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/cuentas/{clientId}")
    public ResponseEntity<?> findAccountsByClientId(@PathVariable("clientId") String clientId) {
        return ResponseEntity.ok(clientService.findAccountsByClientId(clientId));
    }
    
}
