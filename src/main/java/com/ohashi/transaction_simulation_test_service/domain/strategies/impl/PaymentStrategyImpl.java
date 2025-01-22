package com.ohashi.transaction_simulation_test_service.domain.strategies.impl;

import com.ohashi.transaction_simulation_test_service.domain.entities.Accounts;
import com.ohashi.transaction_simulation_test_service.domain.entities.Transactions;
import com.ohashi.transaction_simulation_test_service.domain.entities.enums.OperationType;
import com.ohashi.transaction_simulation_test_service.domain.strategies.OperationStrategy;
import com.ohashi.transaction_simulation_test_service.resources.repositories.TransactionsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component("payment")
public class PaymentStrategyImpl implements OperationStrategy {

    private static final Logger logger = LoggerFactory.getLogger(PaymentStrategyImpl.class);

    private final TransactionsRepository transactionsRepository;

    public PaymentStrategyImpl(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    @Override
    public void processOperation(Accounts account, Double amount, OperationType operationType) {
        logger.info("Initiate a buy in cash operation to account: {}", account.getId());

        var newTransaction = new Transactions.Builder()
                .setAccountId(account)
                .setOperationTypeId(Integer.valueOf(operationType.getId()))
                .setAmount(Math.abs(amount))
                .setEventDate(LocalDateTime.now())
                .build();

        logger.info("New transaction created: {}", newTransaction);
        transactionsRepository.save(newTransaction);
    }
}
