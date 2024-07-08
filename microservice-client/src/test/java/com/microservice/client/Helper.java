package com.microservice.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Helper {
    public static String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper();
        return m.writeValueAsString(object);
    }
}
