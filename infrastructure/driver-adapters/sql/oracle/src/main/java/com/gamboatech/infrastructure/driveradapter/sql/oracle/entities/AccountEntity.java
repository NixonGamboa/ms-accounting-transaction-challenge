package com.gamboatech.infrastructure.driveradapter.sql.oracle.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "accounts")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long accountNumber;
    private String type;
    private Long initialBalance;
    private Boolean status;
    private String clientId;
    private Long availableBalance;
}
