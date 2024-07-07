package com.microservice.client.web.http.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

import com.microservice.client.web.dto.AccountDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountsByClientResponse {
    private String clientName;
    private List<AccountDTO> accounts;
}
