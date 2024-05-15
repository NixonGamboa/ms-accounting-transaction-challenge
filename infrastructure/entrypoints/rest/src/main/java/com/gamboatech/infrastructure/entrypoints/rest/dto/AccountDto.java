package com.gamboatech.infrastructure.entrypoints.rest.dto;

import com.gamboatech.domain.commons.AccountType;
import com.gamboatech.domain.model.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

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
        Account account = new Account()
                .setId(this.id)
                .setAccountNumber(this.accountNumber)
                .setTypeFromString(this.type)
                .setInitialBalance(this.initialBalance)
                .setStatus(this.status)
                .setClientId(this.clientId);
        if(Objects.nonNull(this.movements)){
            return account.setMovements(this.movements.stream().map(MovementDto::toModel).toList());
        }
        return account;
    }
    public static AccountDto modelToDto(Account model){
        AccountDto accountDto = new AccountDto()
                .setId(model.getId())
                .setAccountNumber(model.getAccountNumber())
                .setType(model.getTypeToString())
                .setInitialBalance(model.getInitialBalance())
                .setStatus(model.getStatus())
                .setClientId(model.getClientId());
        if(Objects.nonNull(model.getMovements())){
            return accountDto
                .setMovements(model.getMovements().stream().map(MovementDto::modelToDto).toList());
        }
        return accountDto;
    }
}
