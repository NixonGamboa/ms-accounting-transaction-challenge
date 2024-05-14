package com.gamboatech.infrastructure.driveradapter.sql.oracle.repositories;

import com.gamboatech.infrastructure.driveradapter.sql.oracle.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountEntityRepository extends JpaRepository<AccountEntity, Long> {
    List<AccountEntity> findByClientId(Long clientId);
}
