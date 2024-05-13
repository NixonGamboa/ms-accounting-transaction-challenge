package com.gamboatech.application.adapters.driveradapters.sql;

import com.gamboatech.domain.model.Account;

public interface AccountRepositoryAdapter {
    Account save(Account account);

    Account findById(Long id) throws ClassNotFoundException;

    Long delete(Long id);
}
