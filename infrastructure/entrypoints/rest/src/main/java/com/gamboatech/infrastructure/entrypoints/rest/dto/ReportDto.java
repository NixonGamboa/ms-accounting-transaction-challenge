package com.gamboatech.infrastructure.entrypoints.rest.dto;

import com.gamboatech.domain.model.report.Report;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class ReportDto {
    private Long clientId;
    private LocalDateTime initialDate;
    private LocalDateTime endDate;
    private List<AccountDto> accounts;

    public static ReportDto modelToDto(Report model){
        return new ReportDto()
                .setClientId(model.getClientId())
                .setInitialDate(model.getInitialDate())
                .setEndDate(model.getEndDate())
                .setAccounts(model.getAccounts().stream().map(AccountDto::modelToDto).toList());
    }
}
