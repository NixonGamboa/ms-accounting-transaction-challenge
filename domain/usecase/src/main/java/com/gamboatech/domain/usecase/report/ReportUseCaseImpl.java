package com.gamboatech.domain.usecase.report;

import com.gamboatech.domain.model.Account;
import com.gamboatech.domain.model.report.Report;
import com.gamboatech.domain.usecase.acount.AccountUseCase;
import com.gamboatech.domain.usecase.movement.MovementUseCase;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Component
public class ReportUseCaseImpl implements ReportUseCase {

    private final AccountUseCase accountUseCase;
    private final MovementUseCase movementUseCase;

    public ReportUseCaseImpl(AccountUseCase accountUseCase, MovementUseCase movementUseCase) {
        this.accountUseCase = accountUseCase;
        this.movementUseCase = movementUseCase;
    }

    @Override
    public Report generateReport(Long clientId, LocalDateTime initialDate, LocalDateTime endDate) {

        List<Account> accounts = accountUseCase.getByClientId(clientId)
                .stream().map(account -> account.setMovements(
                        movementUseCase.getByAccountIdAndDateBetween(account.getId(), initialDate, endDate)))
                .toList();

        return new Report()
                .setClientId(clientId)
                .setInitialDate(initialDate)
                .setEndDate(endDate)
                .setAccounts(accounts);
    }

}
