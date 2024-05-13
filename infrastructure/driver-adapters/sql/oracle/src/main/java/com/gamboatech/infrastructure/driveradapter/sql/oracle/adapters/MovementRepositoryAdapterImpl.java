package com.gamboatech.infrastructure.driveradapter.sql.oracle.adapters;

import com.gamboatech.application.adapters.driveradapters.sql.MovementRepositoryAdapter;
import com.gamboatech.domain.commons.BusinessException;
import com.gamboatech.domain.commons.ErrorCodes;
import com.gamboatech.domain.model.Movement;
import com.gamboatech.infrastructure.driveradapter.sql.oracle.entities.AccountEntity;
import com.gamboatech.infrastructure.driveradapter.sql.oracle.entities.MovementEntity;
import com.gamboatech.infrastructure.driveradapter.sql.oracle.repositories.MovementEntityRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MovementRepositoryAdapterImpl implements MovementRepositoryAdapter {

    private final MovementEntityRepository repository;

    public MovementRepositoryAdapterImpl(MovementEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Movement save(Movement movement) {
        return toModel(repository.save(toEntity(movement)));
    }

    @Override
    public void deleteByAccountId(Long accountId){
        repository.deleteByAccountId(accountId);
    }

    @Override
    public Movement findById(Long id) {
        Optional<MovementEntity> optionalMovement = repository.findById(id);
        if(optionalMovement.isEmpty()){
            throw new BusinessException(
                    String.format("El movimiento con id: %d no fue encontrado",id)
                    ,ErrorCodes.NOT_FOUND);
        }
        return toModel(optionalMovement.get());
    }

    private Movement toModel(MovementEntity entity){
        return new Movement()
                .setId(entity.getId())
                .setAccountId(entity.getAccountId())
                .setDate(entity.getMovementDate())
                .setType(entity.getType())
                .setValue(entity.getValue())
                .setNewBalance(entity.getNewBalance());
    }
    private MovementEntity toEntity(Movement model){
        return new MovementEntity()
                .setId(model.getId())
                .setAccountId(model.getAccountId())
                .setMovementDate(model.getDate())
                .setType(model.getType())
                .setValue(model.getValue())
                .setNewBalance(model.getNewBalance());
    }
}
