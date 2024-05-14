package com.gamboatech.domain.usecase.movement;

import com.gamboatech.domain.model.Movement;

import java.time.LocalDateTime;
import java.util.List;

public interface MovementUseCase {

    Movement register(Movement movement);

    Movement cancel(Long id);

    List<Movement> getByAccountIdAndDateBetween(Long accountId, LocalDateTime initialDate, LocalDateTime endDate);
}
