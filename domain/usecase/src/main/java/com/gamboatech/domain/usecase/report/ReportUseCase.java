package com.gamboatech.domain.usecase.report;

import com.gamboatech.domain.model.report.Report;

import java.time.LocalDateTime;

public interface ReportUseCase {
    Report generateReport(Long clientId, LocalDateTime initialDate, LocalDateTime endDate);
}
