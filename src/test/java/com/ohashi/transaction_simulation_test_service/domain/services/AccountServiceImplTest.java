package com.ohashi.transaction_simulation_test_service.domain.services;

import com.ohashi.transaction_simulation_test_service.resources.repositories.AccountsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AccountServiceImplTest {

    @Autowired
    private AccountsService accountsService;

    @Autowired
    private AccountsRepository accountsRepository;

    @Test
    void testCreateAccount_whenHasAValidData_shouldBeCreate() {

    }
}
