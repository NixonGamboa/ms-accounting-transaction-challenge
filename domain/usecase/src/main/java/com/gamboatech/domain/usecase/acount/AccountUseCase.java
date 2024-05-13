package com.gamboatech.domain.usecase.acount;

import com.gamboatech.domain.model.Account;

public interface AccountUseCase {
    Account create(Account account);

    Account update(Account account);

    void  delete(Long id);
}
