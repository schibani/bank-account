package com.sgib.kata;

public class Account {

    private long balance;

    public Account() {}

    public Account(long initialBalance) {
        this.balance = initialBalance;
    }

    public void incrementBalance(final long amount) {
        this.balance += amount;
    }

    public void makeWithdraw(final long amount) {
        this.balance -= amount;
    }

    public long getBalance() {
        return balance;
    }
}
