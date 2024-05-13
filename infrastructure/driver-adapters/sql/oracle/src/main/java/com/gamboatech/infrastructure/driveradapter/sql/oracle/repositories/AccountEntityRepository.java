package com.gamboatech.infrastructure.driveradapter.sql.oracle.repositories;

import com.gamboatech.infrastructure.driveradapter.sql.oracle.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountEntityRepository extends JpaRepository<AccountEntity, Long> {
}
