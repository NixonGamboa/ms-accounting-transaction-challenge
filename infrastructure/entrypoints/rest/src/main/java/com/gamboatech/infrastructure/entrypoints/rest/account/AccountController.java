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
    public AccountDto create(@RequestBody AccountDto accountDto){
        return AccountDto.modelToDto(accountUsecase.create(accountDto.toModel()));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AccountDto> edit(
            @PathVariable("id") Long id,
            @RequestParam(name = "status", required = false) Boolean status,
            @RequestParam(name = "type", required = false) String type
    ) {
        try {
            return ResponseEntity.ok(AccountDto.modelToDto(accountUsecase.edit(id,status,type)));
        } catch (ClassNotFoundException e){
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        accountUsecase.delete(id);
    }
}
