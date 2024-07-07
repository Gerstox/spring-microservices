package com.microservice.client.service.implementations;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.client.network.AccountClient;
import com.microservice.client.persistence.entity.ClientEntity;
import com.microservice.client.persistence.repository.ClientRepository;
import com.microservice.client.service.interfaces.IClientService;
import com.microservice.client.utils.ManageProperties;
import com.microservice.client.web.dto.AccountDTO;
import com.microservice.client.web.dto.ClientDTO;
import com.microservice.client.web.dto.CreateClientDTO;
import com.microservice.client.web.dto.UpdateClientDTO;
import com.microservice.client.web.http.response.AccountsByClientResponse;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AccountClient accountClient;

    @Override
    public List<ClientDTO> findAll() {
        List<ClientEntity> clients = this.clientRepository.findAll();
        return clients.stream().map(client -> this.modelMapper.map(client, ClientDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ClientDTO findById(String clientId) {
        ClientEntity client = this.clientRepository.findById(clientId).orElseThrow(() -> new EntityNotFoundException("Client not found"));
        return this.modelMapper.map(client, ClientDTO.class);
    }

    @Override
    public ClientDTO create(CreateClientDTO clientDTO) {

        ClientEntity clientEntity = this.modelMapper.map(clientDTO, ClientEntity.class);
        clientEntity.setStatus(true);
        this.clientRepository.save(clientEntity);
        clientDTO.setPassword(null);
        return this.modelMapper.map(clientEntity, ClientDTO.class);
    }

    @Override
    public ClientDTO update(String clientId, UpdateClientDTO clientDTO) {
        ClientEntity clientEntity = this.clientRepository.findById(clientId).orElseThrow(() -> new EntityNotFoundException("Client not found"));
        clientEntity = ManageProperties.addProperties(clientDTO, clientEntity);
        ClientEntity updatedClient = this.clientRepository.save(clientEntity);
        return this.modelMapper.map(updatedClient, ClientDTO.class);
    }

    @Override
    public void delete(String clientId) {
        ClientEntity client = this.clientRepository.findById(clientId).orElseThrow(() -> new EntityNotFoundException("Client not found"));
        client.setStatus(false);
        this.clientRepository.save(client);
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
