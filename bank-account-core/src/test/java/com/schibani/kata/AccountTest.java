package com.schibani.kata;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private Account account = new Account();

    @Test
    public void addDepositOperation_amount_depositOperationAdded() {
        // given
        final int amount = 200;
        final Account account = new Account(100);
        final int lastOperationsNumber = account.getOperations().size();

        // when
        account.addDepositOperation(amount);

        // then
        assertThat(account.getOperations()).as("actual number of operations").hasSize(lastOperationsNumber + 1);
        final Operation lastOperation = account.getOperations().stream().reduce((left, right) -> right).get();
        assertThat(lastOperation.getAmount()).isEqualTo(amount);
        assertThat(lastOperation.getOperationType()).isEqualTo(OperationType.DEPOSIT);
        assertThat(lastOperation.getBalance()).isEqualTo(300);
        assertThat(account.getBalance()).isEqualTo(300);
    }

    @Test
    public void addWithdrawalOperation_amount_withdrawalOperationAdded() {
        // given
        final int amount = 50;
        final Account account = new Account(200);
        final int lastOperationsNumber = account.getOperations().size();

        // when
        account.addWithdrawalOperation(amount);

        // then
        assertThat(account.getOperations()).as("actual number of operations").hasSize(lastOperationsNumber + 1);
        final Operation lastOperation = account.getOperations().stream().reduce((left, right) -> right).get();
        assertThat(lastOperation.getAmount()).isEqualTo(amount);
        assertThat(lastOperation.getOperationType()).isEqualTo(OperationType.WITHDRAWAL);
        assertThat(lastOperation.getBalance()).isEqualTo(150);
        assertThat(account.getBalance()).isEqualTo(150);
    }

    @Test
    public void getIncrementedBalance_amount_correctIncrementedBalance() {
        // given
        final int amount = 50;
        final Account account = new Account(100);

        // when
        final long incrementedBalance = account.getIncrementedBalance(amount);

        // then
        assertThat(incrementedBalance).as("new balance").isEqualTo(150);
    }

    @Test
    public void getDecrementedBalance_amount_correctDecrementedBalance() {
        // given
        final int amount = 120;
        final Account account = new Account(200);

        // when
        final long decrementedBalance = account.getDecrementedBalance(amount);

        // then
        assertThat(decrementedBalance).as("new balance remained").isEqualTo(80);
    }
}
