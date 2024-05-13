package com.gamboatech.infrastructure.driveradapter.sql.oracle.repositories;

import com.gamboatech.infrastructure.driveradapter.sql.oracle.entities.MovementEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovementEntityRepository extends JpaRepository<MovementEntity, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM MovementEntity e WHERE e.accountId = :accountId")
    void deleteByAccountId(@Param("accountId") Long accountId);
}
