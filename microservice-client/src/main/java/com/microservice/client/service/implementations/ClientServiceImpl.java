package com.microservice.client.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.client.network.AccountClient;
import com.microservice.client.persistence.entity.ClientEntity;
import com.microservice.client.persistence.repository.ClientRepository;
import com.microservice.client.service.interfaces.IClientService;
import com.microservice.client.web.dto.AccountDTO;
import com.microservice.client.web.http.response.AccountsByClientResponse;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountClient accountClient;

    @Override
    public List<ClientEntity> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public ClientEntity findById(String clientId) {
        return clientRepository.findById(clientId).orElseThrow();
    }

    @Override
    public ClientEntity create(ClientEntity client) {
        return clientRepository.save(client);
    }

    @Override
    public ClientEntity update(String clientId, ClientEntity client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String clientId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public AccountsByClientResponse findAccountsByClientId(String clientId) {
        // Get client
        ClientEntity client = clientRepository.findById(clientId).orElse(new ClientEntity());

        // Get accounts
        List<AccountDTO> accounts = accountClient.findAllACcountsByClient(clientId);

        return AccountsByClientResponse.builder()
            .clientName(client.getName())
            .accounts(accounts)
            .build();
    }
    
}
