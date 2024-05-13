package com.gamboatech.domain.usecase.acount;

import com.gamboatech.domain.model.Account;

public interface AccountUseCase {
    Account create(Account account);

    Account edit(Long id, Boolean status, String type) throws ClassNotFoundException;

    Long  delete(Long id) throws ClassNotFoundException;

    Long updateBalance(Long accountId, Long movementValue) throws ClassNotFoundException;
}
