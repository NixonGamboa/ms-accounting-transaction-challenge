package com.gamboatech.infrastructure.driveradapter.sql.oracle.repositories;

import com.gamboatech.infrastructure.driveradapter.sql.oracle.entities.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementEntityRepository extends JpaRepository<MovementEntity, Long> {
}
