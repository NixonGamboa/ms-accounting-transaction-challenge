package com.gamboatech.domain.model;

import com.gamboatech.domain.commons.AccountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

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

    public String getTypeToString(){
        if(Objects.isNull(this.type)){
            return null;
        }
        return this.type.toString();
    }

    public Account setTypeFromString(String type){
        if(Objects.isNull(type) || type.isEmpty()){
            return this.setType(null);
        }
        return this.setType(AccountType.valueOf(type));
    }
}
