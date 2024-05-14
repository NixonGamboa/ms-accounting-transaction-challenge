package com.gamboatech.infrastructure.entrypoints.rest.controller;

import com.gamboatech.domain.model.report.Report;
import com.gamboatech.domain.usecase.report.ReportUseCase;
import com.gamboatech.infrastructure.entrypoints.rest.dto.ReportDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/reportes")
public class ReportController {
    private final ReportUseCase reportUseCase;

    public ReportController(ReportUseCase reportUseCase) {
        this.reportUseCase = reportUseCase;
    }

    @GetMapping
    public ResponseEntity<ReportDto> accountStatus(
            @RequestParam("client_id") Long clientId,
            @RequestParam("fecha_inicial") LocalDateTime initialDate,
            @RequestParam("fecha_final") LocalDateTime endDate){

        Report report = reportUseCase.generateReport(clientId, initialDate,endDate);
        ReportDto response = ReportDto.modelToDto(report);
        return ResponseEntity.ok(response);
    }
}
