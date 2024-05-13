package com.gamboatech.infrastructure.entrypoints.rest.dto;

import com.gamboatech.domain.model.Account;
import com.gamboatech.domain.model.Movement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MovementDto {

    private Long id;
    private Long accountId;
    private LocalDateTime date;
    private String type;
    private Long value;
    private Long newBalance;

    public Movement toModel(){
        return new Movement()
                .setId(this.id)
                .setAccountId(this.accountId)
                .setDate(this.date)
                .setType(this.type)
                .setValue(this.value)
                .setNewBalance(this.newBalance);
    }
    public static MovementDto modelToDto(Movement model){
        return new MovementDto()
                .setId(model.getId())
                .setAccountId(model.getAccountId())
                .setDate(model.getDate())
                .setType(model.getType())
                .setValue(model.getValue())
                .setNewBalance(model.getNewBalance());
    }
}
