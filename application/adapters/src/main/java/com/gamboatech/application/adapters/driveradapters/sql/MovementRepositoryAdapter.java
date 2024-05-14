package com.gamboatech.application.adapters.driveradapters.sql;

import com.gamboatech.domain.model.Movement;

import java.time.LocalDateTime;
import java.util.List;

public interface MovementRepositoryAdapter {
    Movement save(Movement movement);
    void deleteByAccountId(Long accountId);

    Movement findById(Long id);

    List<Movement> findByAccountIdAndDateBetween(Long accountId, LocalDateTime initialDate, LocalDateTime endDate);
}
