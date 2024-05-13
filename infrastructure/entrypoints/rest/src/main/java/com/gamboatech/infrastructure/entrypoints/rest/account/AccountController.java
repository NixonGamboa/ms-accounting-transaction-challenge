package com.gamboatech.infrastructure.entrypoints.rest.account;

import com.gamboatech.domain.usecase.acount.AccountUseCase;
import com.gamboatech.infrastructure.entrypoints.rest.dto.AccountDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/cuentas")
public class AccountController {
    private final AccountUseCase accountUsecase;

    public AccountController(AccountUseCase accountUsecase) {
        this.accountUsecase = accountUsecase;
    }


    @PostMapping
    public ResponseEntity<AccountDto> create(@RequestBody AccountDto accountDto){
        AccountDto response = AccountDto.modelToDto(accountUsecase.create(accountDto.toModel()));
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AccountDto> edit(
            @PathVariable("id") Long id,
            @RequestParam(name = "status", required = false) Boolean status,
            @RequestParam(name = "type", required = false) String type
    ) {
        return ResponseEntity.ok(AccountDto.modelToDto(accountUsecase.edit(id,status,type)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(accountUsecase.delete(id));
    }

}
