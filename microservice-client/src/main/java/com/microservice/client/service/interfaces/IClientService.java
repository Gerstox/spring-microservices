package com.microservice.client.service.interfaces;

import java.util.List;

import com.microservice.client.web.dto.ClientDTO;
import com.microservice.client.web.dto.CreateClientDTO;
import com.microservice.client.web.dto.UpdateClientDTO;
import com.microservice.client.web.http.response.AccountsByClientResponse;

public interface IClientService {
    List<ClientDTO> findAll();
    
    ClientDTO findById(String clientId);

    ClientDTO create(CreateClientDTO clientDTO);

    ClientDTO update(String clientId, UpdateClientDTO clientDTO);

    void delete(String clientId);

    AccountsByClientResponse findAccountsByClientId(String clientId);


}