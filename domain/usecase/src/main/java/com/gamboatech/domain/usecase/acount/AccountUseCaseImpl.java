package com.gamboatech.domain.usecase.acount;

import com.gamboatech.application.adapters.driveradapters.sql.AccountRepositoryAdapter;
import com.gamboatech.domain.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountUseCaseImpl implements AccountUseCase{

    private final AccountRepositoryAdapter repositoryAdapter;

    public AccountUseCaseImpl(AccountRepositoryAdapter repositoryAdapter) {
        this.repositoryAdapter = repositoryAdapter;
    }

    @Override
    public Account create(Account account) {
        return repositoryAdapter.save(buildNewAccount(account));
    }

    @Override
    public Account update(Account account) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    private Account buildNewAccount(Account account){
        return account.setAvailableBalance(account.getInitialBalance());
    }
}
