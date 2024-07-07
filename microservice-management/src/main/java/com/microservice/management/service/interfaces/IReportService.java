package com.microservice.management.service.interfaces;

import java.util.List;

import com.microservice.management.persistence.projection.AccountStatusReport;

import java.util.Date;

public interface IReportService {
    public List<AccountStatusReport> generateAccountStatusReport(Date startDate, Date endDate, String clientId);
}