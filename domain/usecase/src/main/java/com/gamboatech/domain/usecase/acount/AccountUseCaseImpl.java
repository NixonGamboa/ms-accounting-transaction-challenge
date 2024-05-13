package com.gamboatech.domain.usecase.acount;

import com.gamboatech.application.adapters.driveradapters.sql.AccountRepositoryAdapter;
import com.gamboatech.domain.commons.AccountType;
import com.gamboatech.domain.model.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;

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
    public Account edit(Long id, Boolean status, String type) throws ClassNotFoundException {
        return repositoryAdapter.save(getUpdatedAccount(id, status, type));
    }

    @Override
    public void delete(Long id) {

    }

    private Account buildNewAccount(Account account){
        return account.setAvailableBalance(account.getInitialBalance());
    }

    private Account getUpdatedAccount(Long id, Boolean status, String type) throws ClassNotFoundException {
        Account currentAccount = repositoryAdapter.findById(id);

        if(Objects.isNull(currentAccount.getId())){
            throw new ClassNotFoundException(String.format("La cuenta con id: %d no fue encontrada",id));
        }

        return currentAccount
                .setStatus(Objects.nonNull(status)? status : currentAccount.getStatus())
                .setType(Objects.nonNull(type)? AccountType.valueOf(type): currentAccount.getType());
    }
}
