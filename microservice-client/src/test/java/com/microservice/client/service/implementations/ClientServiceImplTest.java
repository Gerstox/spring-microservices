package com.microservice.client.service.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.microservice.client.DataProvider;
import com.microservice.client.persistence.entity.ClientEntity;
import com.microservice.client.persistence.repository.ClientRepository;
import com.microservice.client.utils.ManageProperties;
import com.microservice.client.web.dto.ClientDTO;
import com.microservice.client.web.dto.CreateClientDTO;

import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = ClientServiceImplTest.class)
public class ClientServiceImplTest {

    
    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ManageProperties manageProperties;
    
    @InjectMocks
    private ClientServiceImpl clientService;

    private ClientEntity clientEntity;
    private ClientDTO clientDTO;
    private CreateClientDTO createClientDTO;
    
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        clientEntity = DataProvider.getClient();

        clientDTO = DataProvider.getClientDTO();

        createClientDTO = DataProvider.getCreateClientDTO();
    }
    
    @Test
    public void testFindAll() {
        
        when(clientRepository.findAll()).thenReturn(List.of(clientEntity));

        assertNotNull(clientService.findAll());
    }

    @Test
    public void testFindById() {
        String clientId = "9be03a03-3bec-11ef-af54-00e04c0602f2";

        when(clientRepository.findById(clientId)).thenReturn(Optional.of(clientEntity));
        when(modelMapper.map(clientEntity, ClientDTO.class)).thenReturn(clientDTO);
        Optional<ClientEntity> response = clientRepository.findById(clientId);

        assertNotNull(clientService.findById(clientId));
        assertEquals("9be03a03-3bec-11ef-af54-00e04c0602f2", response.get().getId());
        assertEquals("0001", response.get().getIdentification());
        assertEquals("Jose Lema", response.get().getName());
        assertEquals("Otavalo sn y principal", response.get().getAddress());
        assertEquals("098254785", response.get().getPhone());
        assertEquals("1234", response.get().getPassword());
    }

    @Test
    public void testCreate() {
        
        when(modelMapper.map(createClientDTO, ClientEntity.class)).thenReturn(clientEntity);
        when(clientRepository.save(any(ClientEntity.class))).thenReturn(clientEntity);
        when(modelMapper.map(clientEntity, ClientDTO.class)).thenReturn(clientDTO);
        ClientDTO response = clientService.create(createClientDTO);

        assertNotNull(clientService.create(createClientDTO));
        assertNotNull(response.getId());
    }

}
