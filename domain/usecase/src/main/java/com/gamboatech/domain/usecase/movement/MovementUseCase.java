package com.gamboatech.domain.usecase.movement;

import com.gamboatech.domain.model.Movement;

public interface MovementUseCase {

    Movement register(Movement movement) throws ClassNotFoundException;

    Movement cancel(Long id);
}
