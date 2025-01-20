package com.ohashi.transaction_simulation_test_service.domain.strategies.impl;

import com.ohashi.transaction_simulation_test_service.domain.entities.enums.OperationType;
import com.ohashi.transaction_simulation_test_service.domain.strategies.OperationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("1")
public class BuyInCashStrategyImpl implements OperationStrategy {

    private static final Logger logger = LoggerFactory.getLogger(BuyInCashStrategyImpl.class);

    @Override
    public void processOperation() {
        logger.info("BuyInCashStrategyImpl");
    }
}
