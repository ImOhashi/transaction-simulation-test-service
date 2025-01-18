package com.ohashi.transaction_simulation_test_service.domain.services.impl;

import com.ohashi.transaction_simulation_test_service.domain.entities.Accounts;
import com.ohashi.transaction_simulation_test_service.domain.exceptions.AccountAlreadyExistsException;
import com.ohashi.transaction_simulation_test_service.domain.exceptions.InvalidDocumentNumberException;
import com.ohashi.transaction_simulation_test_service.domain.services.AccountsService;
import com.ohashi.transaction_simulation_test_service.domain.utils.CpfValidator;
import com.ohashi.transaction_simulation_test_service.resources.AccountsRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AccountsServiceImpl implements AccountsService {

    private static final Logger logger = LoggerFactory.getLogger(AccountsServiceImpl.class);

    private final AccountsRepository accountsRepository;

    public AccountsServiceImpl(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @Override
    public void createAccount(String documentNumber) {
        logger.info("Attempting to create account with document number: {}", documentNumber);
        accountsRepository.findByDocumentNumber(documentNumber).ifPresentOrElse(account -> {
            logger.error("Account with document number {} already exists", documentNumber);
            throw new AccountAlreadyExistsException("Account with document number " + documentNumber + " already exists");
        }, () -> {
            validateDocumentNumber(documentNumber);

            var newAccount = new Accounts.Builder()
                    .setDocumentNumber(documentNumber)
                    .build();

            accountsRepository.save(newAccount);
        });
    }

    private static void validateDocumentNumber(String documentNumber) {
        logger.info("Validating document number: {}", documentNumber);
        if (!CpfValidator.isValidCPF(documentNumber)) {
            throw new InvalidDocumentNumberException("Invalid document number: " + documentNumber);
        }
    }
}
