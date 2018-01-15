package com.schibani.bankaccount;

public enum OperationType {
    DEPOSIT ("Deposit"), WITHDRAWAL("Withdrawal");

    private final String label;

    OperationType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}