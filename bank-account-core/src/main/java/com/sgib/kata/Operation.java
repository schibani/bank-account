package com.sgib.kata;

import java.time.ZonedDateTime;

import static com.sgib.kata.Utils.DATE_FORMATTER;

public class Operation {

    private final OperationType operationType;
    private final long amount;
    private final long balance;
    private final ZonedDateTime dateTime;

    public Operation(OperationType operationType, long amount, long balance) {
        this.operationType = operationType;
        this.amount = amount;
        this.balance = balance;
        this.dateTime = ZonedDateTime.now();
    }

    public boolean isOperationInPeriod(ZonedDateTime from, ZonedDateTime to) {
        return dateTime.isAfter(from) && dateTime.isBefore(to);
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public long getAmount() {
        return amount;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public long getBalance() {
        return balance;
    }

    public String getPretyFormat() {
            return String.format("%s    %s  %s  %s", DATE_FORMATTER.format(dateTime), operationType.getLabel(), amount, balance);
    }
}