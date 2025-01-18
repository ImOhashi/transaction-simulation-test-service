package com.ohashi.transaction_simulation_test_service.domain.entities.enums;

public enum OperationType {
    COMPRA_A_VISTA(1),
    COMPRA_PARCELADA(2),
    SAQUE(3),
    PAGAMENTO(4);

    private final int id;

    OperationType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
