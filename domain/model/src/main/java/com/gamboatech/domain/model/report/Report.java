package com.gamboatech.domain.model.report;

import com.gamboatech.domain.model.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class Report {

    private Long clientId;
    private LocalDateTime initialDate;
    private LocalDateTime endDate;
    private List<Account> accounts;
}
