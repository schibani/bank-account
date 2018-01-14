package com.sgib.kata;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private Account account = new Account();

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
}