package com.ohashi.transaction_simulation_test_service.domain.services;

import com.ohashi.transaction_simulation_test_service.application.dtos.requests.CreateAccountDto;

public interface AccountsService {
    void createAccount(CreateAccountDto createAccountDto);
}
