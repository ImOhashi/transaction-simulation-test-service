package com.ohashi.transaction_simulation_test_service.domain.services;

import com.ohashi.transaction_simulation_test_service.application.dtos.requests.CreateAccountDto;
import com.ohashi.transaction_simulation_test_service.application.dtos.responses.GetAccountInfoResponse;

public interface AccountsService {
    void createAccount(CreateAccountDto createAccountDto);
    GetAccountInfoResponse getAccountInfo(Integer id);
}
