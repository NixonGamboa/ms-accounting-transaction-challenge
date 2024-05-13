package com.gamboatech.infrastructure.entrypoints.rest.account;

import com.gamboatech.domain.usecase.acount.AccountUseCase;
import com.gamboatech.infrastructure.entrypoints.rest.dto.AccountDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
public class AccountController {
    private final AccountUseCase accountUsecase;

    public AccountController(AccountUseCase accountUsecase) {
        this.accountUsecase = accountUsecase;
    }


    @PostMapping
    public AccountDto create(@RequestBody AccountDto accountDto){
        return AccountDto.modelToDto(accountUsecase.create(accountDto.toModel()));
    }

    //TODO: definir campos a actualizar
    @PutMapping
    public AccountDto update(@RequestBody AccountDto accountDto){
        return AccountDto.modelToDto(accountUsecase.update(accountDto.toModel()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        accountUsecase.delete(id);
    }
}
