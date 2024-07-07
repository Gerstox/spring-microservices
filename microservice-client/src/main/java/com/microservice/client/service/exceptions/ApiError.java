package com.microservice.client.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ApiError {

    private Integer errorCode;
    private String errorDesc;
    private Date date;
    
}