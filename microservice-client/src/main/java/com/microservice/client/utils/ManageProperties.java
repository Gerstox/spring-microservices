package com.microservice.client.utils;

import com.microservice.client.persistence.entity.ClientEntity;
import com.microservice.client.web.dto.UpdateClientDTO;

public class ManageProperties {
    public static ClientEntity addProperties(UpdateClientDTO source, ClientEntity target) {
        if(source.getName() != null) {
            target.setName(source.getName());
        }

        if(source.getGender() != null) {
            target.setGender(source.getGender());
        }

        if(source.getAge() != null) {
            target.setAge(source.getAge());
        }

        if(source.getAddress() != null) {
            target.setAddress(source.getAddress());
        }

        if(source.getPhone() != null) {
            target.setPhone(source.getPhone());
        }

        if(source.getPassword() != null) {
            target.setPassword(source.getPassword());
        }

        return target;
    }
}
