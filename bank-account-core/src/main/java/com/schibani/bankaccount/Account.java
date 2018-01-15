package com.schibani.bankaccount;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private long balance;
    private List<Operation> operations = new ArrayList();

    public Account() {
    }

    public Account(long initialBalance) {
        this.balance = initialBalance;
    }

    public void addDepositOperation(final long amount) {
        long actualBalance = getIncrementedBalance(amount);
        operations.add(new Operation(OperationType.DEPOSIT, amount, actualBalance));
        this.balance = actualBalance;
    }

    public void addWithdrawalOperation(final long amount) {
        long actualBalance = getDecrementedBalance(amount);
        operations.add(new Operation(OperationType.WITHDRAWAL, amount, actualBalance));
        this.balance = actualBalance;
    }

    public boolean isBalanceSufficient(long amount) {
        return balance >= amount;
    }

    public long getIncrementedBalance(long amount) {
        return balance + amount;
    }

    public long getDecrementedBalance(long amount) {
        return balance - amount;
    }

    public long getBalance() {
        return balance;
    }

    public List<Operation> getOperations() {
        return operations;
    }
}
