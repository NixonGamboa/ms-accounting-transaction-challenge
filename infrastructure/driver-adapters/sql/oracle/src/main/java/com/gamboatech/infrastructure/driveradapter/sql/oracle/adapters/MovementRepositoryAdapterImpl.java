package com.gamboatech.infrastructure.driveradapter.sql.oracle.adapters;

import com.gamboatech.application.adapters.driveradapters.sql.MovementRepositoryAdapter;
import com.gamboatech.domain.model.Movement;
import com.gamboatech.infrastructure.driveradapter.sql.oracle.entities.MovementEntity;
import com.gamboatech.infrastructure.driveradapter.sql.oracle.repositories.MovementEntityRepository;
import org.springframework.stereotype.Component;

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
