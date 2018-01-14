package com.sgib.kata;

import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private Account account = new Account();

    @Test
    public void addDepositOperation_amount_depositOperationAdded() {
        // given
        final int amount = 50;
        final Account account = new Account(100);
        final int lastOperationsNumber = account.getOperations().size();

        // when
        account.addDepositOperation(amount);

        // then
        assertThat(account.getOperations()).as("actual operations number").hasSize(lastOperationsNumber + 1);
        final Operation lastOperation = account.getOperations().stream().reduce((left, right) -> right).get();
        assertThat(lastOperation.getAmount()).isEqualTo(amount);
        assertThat(lastOperation.getOperationType()).isEqualTo(OperationType.DEPOSIT);
    }

    @Test
    public void addWithdrawalOperation_amount_depositOperationAdded() {
        // given
        final int amount = 50;
        final Account account = new Account();
        final int lastOperationsNumber = account.getOperations().size();

        // when
        account.addWithdrawalOperation(amount);

        // then
        assertThat(account.getOperations()).as("actual operations number").hasSize(lastOperationsNumber + 1);
        final Operation lastOperation = account.getOperations().stream().reduce((left, right) -> right).get();
        assertThat(lastOperation.getAmount()).isEqualTo(amount);
        assertThat(lastOperation.getOperationType()).isEqualTo(OperationType.WITHDRAWAL);
    }

    @Test
    public void incrementBalance_amount_balanceIncremented() {
        // given
        final int amount = 50;
        final Account account = new Account(100);

        // when
        account.incrementBalance(amount);

        // then
        assertThat(account.getBalance()).as("total balance").isEqualTo(150);
    }

    @Test
    public void decrementBalance_amount_balanceDecremented() {
        // given
        final int amount = 120;
        final Account account = new Account(200);

        // when
        account.decrementBalance(amount);

        // then
        assertThat(account.getBalance()).as("total balance remained").isEqualTo(80);
    }
}
