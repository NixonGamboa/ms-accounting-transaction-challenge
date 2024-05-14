package com.gamboatech.infrastructure.entrypoints.rest.dto;

import com.gamboatech.domain.commons.AccountType;
import com.gamboatech.domain.model.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AccountDto {

    private Long id;
    private Long accountNumber;
    private String type;
    private Long initialBalance;
    private Boolean status;
    private Long clientId;
    private List<MovementDto> movements;

    public Account toModel(){
        return new Account()
                .setId(this.id)
                .setAccountNumber(this.accountNumber)
                .setTypeFromString(this.type)
                .setInitialBalance(this.initialBalance)
                .setStatus(this.status)
                .setClientId(this.clientId)
                .setMovements(this.movements.stream().map(MovementDto::toModel).toList());
    }
    public static AccountDto modelToDto(Account model){
        return new AccountDto()
                .setId(model.getId())
                .setAccountNumber(model.getAccountNumber())
                .setType(model.getTypeToString())
                .setInitialBalance(model.getInitialBalance())
                .setStatus(model.getStatus())
                .setClientId(model.getClientId())
                .setMovements(model.getMovements().stream().map(MovementDto::modelToDto).toList());
    }
}
