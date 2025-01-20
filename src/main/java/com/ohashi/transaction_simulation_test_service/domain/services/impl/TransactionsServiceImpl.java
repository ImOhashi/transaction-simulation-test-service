package com.ohashi.transaction_simulation_test_service.domain.services.impl;

import com.ohashi.transaction_simulation_test_service.application.dtos.requests.RegisterTransactionRequest;
import com.ohashi.transaction_simulation_test_service.domain.strategies.OperationStrategy;
import com.ohashi.transaction_simulation_test_service.domain.services.TransactionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionsServiceImpl.class);

    private final Map<String, OperationStrategy> operationStrategies;

    public TransactionsServiceImpl(Map<String, OperationStrategy> operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    @Override
    public void registerTransaction(RegisterTransactionRequest registerTransactionRequest) {
        String strategyKey = registerTransactionRequest.operationTypeId();
        OperationStrategy strategy = operationStrategies.get(strategyKey);

        if (strategy == null) {
            throw new IllegalArgumentException("No strategy found for operation type: " + strategyKey);
        }

        strategy.processOperation();
    }
}
