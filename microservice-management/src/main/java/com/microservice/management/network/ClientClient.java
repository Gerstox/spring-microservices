package com.microservice.management.network;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.management.web.dto.ClientDTO;

@FeignClient(name = "microservice-client", url = "localhost:8080/clientes")
public interface ClientClient {

    @GetMapping("/{clientId}")
    ClientDTO findById(@PathVariable("clientId") String clientId);
    
}
