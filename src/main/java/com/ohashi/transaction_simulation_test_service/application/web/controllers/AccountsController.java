package com.ohashi.transaction_simulation_test_service.application.web.controllers;

import com.ohashi.transaction_simulation_test_service.application.dtos.requests.CreateAccountDto;
import com.ohashi.transaction_simulation_test_service.domain.services.AccountsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    private final AccountsService accountsService;

    public AccountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @PostMapping
    public ResponseEntity<Void> createAccount(@RequestBody CreateAccountDto createAccountDto) {
        accountsService.createAccount(createAccountDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
