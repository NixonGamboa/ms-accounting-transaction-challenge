package com.gamboatech.domain.usecase.report;

import com.gamboatech.application.adapters.driveradapters.restclient.UserClientAdapter;
import com.gamboatech.domain.model.Account;
import com.gamboatech.domain.model.report.Report;
import com.gamboatech.domain.usecase.acount.AccountUseCase;
import com.gamboatech.domain.usecase.movement.MovementUseCase;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Component
public class ReportUseCaseImpl implements ReportUseCase {

    private final UserClientAdapter userClientAdapter;
    private final AccountUseCase accountUseCase;
    private final MovementUseCase movementUseCase;

    public ReportUseCaseImpl(UserClientAdapter userClientAdapter, AccountUseCase accountUseCase, MovementUseCase movementUseCase) {
        this.userClientAdapter = userClientAdapter;
        this.accountUseCase = accountUseCase;
        this.movementUseCase = movementUseCase;
    }

    @Override
    public Report generateReport(String clientIdentificationNumber, LocalDateTime initialDate, LocalDateTime endDate) {

        Long clientId = userClientAdapter.getClientIdByIdentificationNumber(clientIdentificationNumber);
        List<Account> accounts = getAccountsByClientId(clientId,initialDate,endDate);
        return new Report(clientId, initialDate, endDate, accounts);
    }

    private List<Account> getAccountsByClientId(Long clientId, LocalDateTime initialDate, LocalDateTime endDate){
        return accountUseCase.getByClientId(clientId)
                .stream().map(account -> account.setMovements(
                        movementUseCase.getByAccountIdAndDateBetween(account.getId(), initialDate, endDate)))
                .toList();
    }

}
