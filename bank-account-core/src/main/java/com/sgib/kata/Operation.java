package com.sgib.kata;

import java.time.ZonedDateTime;

public class Operation {

    private final OperationType operationType;
    private final long amount;
    private final ZonedDateTime dateTime;

    public Operation(OperationType operationType, long amount) {
        this.operationType = operationType;
        this.amount = amount;
        this.dateTime = ZonedDateTime.now();
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public long getAmount() {
        return amount;
    }

    public ZonedDateTime getZonedDateTime() {
        return dateTime;
    }
}