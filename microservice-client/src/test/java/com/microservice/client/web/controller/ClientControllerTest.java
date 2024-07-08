package com.microservice.client.web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.microservice.client.DataProvider;
import com.microservice.client.Helper;
import com.microservice.client.web.dto.ClientDTO;

// @WebAppConfiguration
// @SpringBootTest(classes = ClientControllerTest.class)
public class ClientControllerTest {

    // private final static String BASE_URL = "/clientes";

    // MockMvc mockMvc;

    // @Autowired
    // private WebApplicationContext webApplicationContext;

    // @BeforeEach
    // void setup() {
    //     mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    // }

    // @Test
    // void findAll() throws Exception {

    //     ClientDTO clientDTO = DataProvider.getE2EClientDTO();

    //     MvcResult mockMvcResult = mockMvc
    //             .perform(MockMvcRequestBuilders.get(BASE_URL)
    //             .accept(MediaType.APPLICATION_JSON_VALUE)
    //             .contentType(MediaType.APPLICATION_JSON_VALUE)
    //             .content(Helper.mapToJson(clientDTO)))
    //         .andReturn();
    //     assertEquals(201, mockMvcResult.getResponse().getStatus());
    // }

    // @Test
    // void create() throws Exception {
    //     MvcResult mockMvcResult = mockMvc
    //             .perform(MockMvcRequestBuilders.post(BASE_URL).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
    //     assertEquals(200, mockMvcResult.getResponse().getStatus());
    // }

}
