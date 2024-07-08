package com.microservice.client;

import com.microservice.client.persistence.entity.ClientEntity;
import com.microservice.client.web.dto.ClientDTO;
import com.microservice.client.web.dto.CreateClientDTO;
import com.microservice.client.web.dto.UpdateClientDTO;

public class DataProvider {
    public static ClientEntity getClient() {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId("9be03a03-3bec-11ef-af54-00e04c0602f2");
        clientEntity.setIdentification("0001");
        clientEntity.setName("Jose Lema");
        clientEntity.setAddress("Otavalo sn y principal");
        clientEntity.setPhone("098254785");
        clientEntity.setPassword("1234");
        clientEntity.setStatus(true);
        return clientEntity;
    }

    public static ClientEntity getNewClient() {
        ClientEntity newClientEntity = new ClientEntity();
        newClientEntity.setId("f72d3fab-7c90-45b9-8072-add1bfaf7911");
        newClientEntity.setIdentification("0010");
        newClientEntity.setName("Jose Tua");
        newClientEntity.setAddress("Address");
        newClientEntity.setPhone("0123456");
        newClientEntity.setPassword("9874");
        newClientEntity.setStatus(true);
        return newClientEntity;
    }

    public static ClientEntity getClientUpdated() {

        ClientEntity updateClient = new ClientEntity();
        updateClient.setName("Jose Lema Doe");
        updateClient.setAddress("Calle 14");
        updateClient.setPhone("098254785");
        updateClient.setPassword("4321");
        updateClient.setStatus(true);
        System.out.println(" -> clientListMock");
        return updateClient;
    }


    public static ClientDTO getClientDTO() {

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId("9be03a03-3bec-11ef-af54-00e04c0602f2");
        clientDTO.setIdentification("0001");
        clientDTO.setName("Jose Lema");
        clientDTO.setAddress("Otavalo sn y principal");
        clientDTO.setPhone("098254785");
        clientDTO.setPassword("1234");
        return clientDTO;
    }

    public static ClientDTO getE2EClientDTO() {

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId("9be03a03-3bec-11ef-af54-00e04c0602f2");
        clientDTO.setIdentification("0001");
        clientDTO.setName("Jose Lema");
        clientDTO.setAddress("Otavalo sn y principal");
        clientDTO.setPhone("098254785");
        clientDTO.setPassword("1234");
        return clientDTO;
    }

    public static CreateClientDTO getCreateClientDTO() {

        CreateClientDTO createClientDTO = new CreateClientDTO();
        createClientDTO.setIdentification("0001");
        createClientDTO.setName("Jose Lema");
        createClientDTO.setAddress("Otavalo sn y principal");
        createClientDTO.setPhone("098254785");
        createClientDTO.setPassword("1234");
        return createClientDTO;
    }

    public static UpdateClientDTO getUpdateClientDTO() {

        UpdateClientDTO updateClientDTO = new UpdateClientDTO();
        updateClientDTO.setName("Jose Lema Doe");
        updateClientDTO.setAddress("Calle 14");
        updateClientDTO.setPhone("098254785");
        updateClientDTO.setPassword("4321");
        return updateClientDTO;
    }
}
