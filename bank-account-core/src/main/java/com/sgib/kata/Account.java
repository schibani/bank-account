package com.sgib.kata;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private long balance;
    private List<Operation> operations = new ArrayList();

    public Account() {}

    public Account(long initialBalance) {
        this.balance = initialBalance;
    }

    public void addDepositOperationAndIncrementBalance(final long amount){
        addDepositOperation(amount);
        incrementBalance(amount);
    }

    public void addWithdrawalOperationAndDecrementBalance(final long amount){
        addWithdrawalOperation(amount);
        decrementBalance(amount);
    }

    public void incrementBalance(final long amount) {
        this.balance += amount;
    }

    public void decrementBalance(final long amount) {
        this.balance -= amount;
    }

    public void addDepositOperation(final long amount){
        operations.add(new Operation(OperationType.DEPOSIT, amount));
    }

    public void addWithdrawalOperation(final long amount){
        operations.add(new Operation(OperationType.WITHDRAWAL, amount));
    }

    public long getBalance() {
        return balance;
    }

    public List<Operation> getOperations() {
        return operations;
    }
}
