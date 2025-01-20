package com.ohashi.transaction_simulation_test_service.domain.strategies.impl;

import com.ohashi.transaction_simulation_test_service.domain.strategies.OperationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("4")
public class PaymentStrategyImpl implements OperationStrategy {

    private static final Logger logger = LoggerFactory.getLogger(PaymentStrategyImpl.class);

    @Override
    public void processOperation() {
        logger.info("PaymentStrategyImpl");
    }
}
