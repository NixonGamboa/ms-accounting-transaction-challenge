package com.gamboatech.domain.usecase.acount;

import com.gamboatech.domain.model.Account;

import java.util.List;

public interface AccountUseCase {
    Account create(Account account);

    Account edit(Long id, Boolean status, String type);

    Long  delete(Long id);

    Long updateBalance(Long accountId, Long movementValue);

    List<Account> getByClientId(Long clientId);
}
