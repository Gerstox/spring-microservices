package com.microservice.client.network;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.client.web.dto.AccountDTO;

import java.util.List;

@FeignClient(name = "microservice-management", url = "localhost:8080/cuentas")
public interface AccountClient {

    @GetMapping("/buscar-por-cliente/{clientId}")
    List<AccountDTO> findAllACcountsByClient(@PathVariable("clientId") String clientId);
}