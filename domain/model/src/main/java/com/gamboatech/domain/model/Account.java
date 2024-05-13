package com.gamboatech.domain.model;

import com.gamboatech.domain.commons.AccountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Account {
    private Long id;
    private Long accountNumber;
    private AccountType type;
    private Long initialBalance;
    private Boolean status;
    private String clientId;
    private Long availableBalance;
}
