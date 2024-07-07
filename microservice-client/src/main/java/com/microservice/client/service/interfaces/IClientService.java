package com.microservice.client.service.interfaces;

import java.util.List;

import com.microservice.client.persistence.entity.ClientEntity;
import com.microservice.client.web.http.response.AccountsByClientResponse;

public interface IClientService {
    List<ClientEntity> findAll();
    
    ClientEntity findById(String clientId);

    ClientEntity create(ClientEntity client);

    ClientEntity update(String clientId, ClientEntity client);

    void delete(String clientId);

    AccountsByClientResponse findAccountsByClientId(String clientId);


}