package com.gamboatech.infrastructure.entrypoints.rest.controller;

import com.gamboatech.domain.commons.BusinessException;
import com.gamboatech.domain.commons.ErrorCodes;
import com.gamboatech.domain.usecase.movement.MovementUseCase;
import com.gamboatech.infrastructure.entrypoints.rest.dto.MovementDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping("/movimientos")
public class MovementController {
    private final MovementUseCase movementUseCase;

    public MovementController(MovementUseCase movementUseCase) {
        this.movementUseCase = movementUseCase;
    }

    @PostMapping
    public ResponseEntity<MovementDto> register(@RequestBody MovementDto movementDto){
        MovementDto response = MovementDto.modelToDto(movementUseCase.register(movementDto.toModel()));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovementDto> cancel(@PathVariable("id") Long id){
        return ResponseEntity.ok(MovementDto.modelToDto(movementUseCase.cancel(id)));
    }
}
