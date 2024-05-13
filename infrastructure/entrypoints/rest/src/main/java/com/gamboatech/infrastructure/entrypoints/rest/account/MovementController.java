package com.gamboatech.infrastructure.entrypoints.rest.account;

import com.gamboatech.domain.commons.BusinessException;
import com.gamboatech.domain.commons.ErrorCodes;
import com.gamboatech.domain.usecase.movement.MovementUseCase;
import com.gamboatech.infrastructure.entrypoints.rest.dto.MovementDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        try {
            MovementDto response = MovementDto.modelToDto(movementUseCase.register(movementDto.toModel()));
            return ResponseEntity.ok(response);
        }catch (BusinessException e){
            if(e.getErrorCode().equals(ErrorCodes.UNAVAILABLE_BALANCE)){
                throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
            }
            throw  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        } catch (ClassNotFoundException e){
            log.error(e.getMessage());
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
