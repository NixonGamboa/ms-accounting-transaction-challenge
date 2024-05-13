package com.gamboatech.application.adapters.driveradapters.sql;

import com.gamboatech.domain.model.Movement;

public interface MovementRepositoryAdapter {
    Movement save(Movement movement);
    void deleteByAccountId(Long accountId);
}
