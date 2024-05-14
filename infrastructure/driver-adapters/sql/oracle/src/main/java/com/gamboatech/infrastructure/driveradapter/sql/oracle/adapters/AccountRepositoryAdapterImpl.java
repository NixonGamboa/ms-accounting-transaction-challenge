package com.gamboatech.infrastructure.driveradapter.sql.oracle.adapters;

import com.gamboatech.application.adapters.driveradapters.sql.AccountRepositoryAdapter;
import com.gamboatech.domain.commons.BusinessException;
import com.gamboatech.domain.commons.ErrorCodes;
import com.gamboatech.domain.model.Account;
import com.gamboatech.infrastructure.driveradapter.sql.oracle.entities.AccountEntity;
import com.gamboatech.infrastructure.driveradapter.sql.oracle.repositories.AccountEntityRepository;
import org.springframework.stereotype.Component;

import java.util.List;
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
    public Account findById(Long id){
        Optional<AccountEntity> optionalAccount =  repository.findById(id);
        if(optionalAccount.isEmpty()){
            throw new BusinessException(
                    String.format("La cuenta con id: %d no fue encontrada",id)
                    , ErrorCodes.NOT_FOUND);
        }
        return toModel(optionalAccount.get());
    }

    @Override
    public Long delete(Long id) {
        repository.deleteById(id);
        return id;
    }

    @Override
    public List<Account> findByClientId(Long clientId) {
        return repository.findByClientId(clientId).stream().map(this::toModel).toList();
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
