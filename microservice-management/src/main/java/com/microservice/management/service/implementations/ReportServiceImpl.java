package com.microservice.management.service.implementations;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.management.network.ClientClient;
import com.microservice.management.persistence.projection.AccountStatusReport;
import com.microservice.management.persistence.repository.AccountRepository;
import com.microservice.management.service.interfaces.IReportService;
import com.microservice.management.web.dto.ClientDTO;

@Service
public class ReportServiceImpl implements IReportService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClientClient clientClient;

    @Override
    public List<AccountStatusReport> generateAccountStatusReport(Date startDate, Date endDate, String clientId) {
        ClientDTO client = this.clientClient.findById(clientId);
        List<AccountStatusReport> report = this.accountRepository.getAccountStatusReport(startDate, endDate, clientId, client.getName());
        return report;
    }
    
}
