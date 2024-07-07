package com.microservice.management.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.management.persistence.projection.AccountStatusReport;
import com.microservice.management.service.interfaces.IReportService;

import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/reportes")
public class ReportController {

    @Autowired
    private IReportService reportService;
    
    @GetMapping
    public ResponseEntity<List<AccountStatusReport>> accountStatus(
        @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
        @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
        @RequestParam("clientId") String clientId
    ) {

        List<AccountStatusReport> result = this.reportService.generateAccountStatusReport(startDate, endDate, clientId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
