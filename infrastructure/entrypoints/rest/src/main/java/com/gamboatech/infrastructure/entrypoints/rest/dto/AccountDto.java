package com.gamboatech.infrastructure.entrypoints.rest.dto;

import com.gamboatech.domain.commons.AccountType;
import com.gamboatech.domain.model.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountDto {

    private Long id;
    private Long accountNumber;
    private String type;
    private Long initialBalance;
    private Boolean status;
    private String clientId;

    public Account toModel(){
        return new Account()
                .setId(this.id)
                .setAccountNumber(this.accountNumber)
                .setTypeFromString(this.type)
                .setInitialBalance(this.initialBalance)
                .setStatus(this.status)
                .setClientId(this.clientId);
    }
    public static AccountDto modelToDto(Account model){
        return new AccountDto()
                .setId(model.getId())
                .setAccountNumber(model.getAccountNumber())
                .setType(model.getTypeToString())
                .setInitialBalance(model.getInitialBalance())
                .setStatus(model.getStatus())
                .setClientId(model.getClientId());
    }
}
