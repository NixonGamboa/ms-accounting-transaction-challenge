package com.gamboatech.infrastructure.driveradapter.sql.oracle.adapters;

import com.gamboatech.application.adapters.driveradapters.sql.AccountRepositoryAdapter;
import com.gamboatech.domain.commons.AccountType;
import com.gamboatech.domain.model.Account;
import com.gamboatech.infrastructure.driveradapter.sql.oracle.entities.AccountEntity;
import com.gamboatech.infrastructure.driveradapter.sql.oracle.repositories.AccountEntityRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class AccountRepositoryAdapterImpl implements AccountRepositoryAdapter {
    private final AccountEntityRepository repository;

    public AccountRepositoryAdapterImpl(AccountEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account save(Account account) {
        return toModel(repository.save(toEntity(account)));
    }

    @Override
    public Account findById(Long id) {
        Optional<AccountEntity> optionalAccount =  repository.findById(id);
        return toModel(optionalAccount.orElseGet(AccountEntity::new));
    }

    private Account toModel(AccountEntity entity){
        return new Account()
                .setId(entity.getId())
                .setAccountNumber(entity.getAccountNumber())
                .setInitialBalance(entity.getInitialBalance())
                .setStatus(entity.getStatus())
                .setClientId(entity.getClientId())
                .setAvailableBalance(entity.getAvailableBalance())
                .setTypeFromString(entity.getType());
    }
    public  AccountEntity toEntity(Account model){
        return new AccountEntity()
                .setId(model.getId())
                .setAccountNumber(model.getAccountNumber())
                .setInitialBalance(model.getInitialBalance())
                .setStatus(model.getStatus())
                .setClientId(model.getClientId())
                .setAvailableBalance(model.getAvailableBalance())
                .setType(model.getTypeToString());
    }
}
