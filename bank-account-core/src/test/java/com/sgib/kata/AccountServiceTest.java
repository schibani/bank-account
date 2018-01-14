package com.sgib.kata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

    @Test
    public void makeDeposit_negativeAmount_throwException() {
        // given

        // when

        // then
    }

    @Test
    public void makeDeposit_zeroAmount_throwException() {
        // given

        // when

        // then
    }

    @Test
    public void makeDeposit_tooBigAmount_throwException() {
        // given

        // when

        // then
    }

    @Test
    public void makeDeposit_validAmount_depositMade() {
        // given

        // when

        // then
    }

    @Test
    public void makeWithdrawal_negativeAmount_throwException() {
        // given

        // when

        // then
    }

    @Test
    public void makeWithdrawal_zeroAmount_throwException() {
        // given

        // when

        // then
    }

    @Test
    public void makeWithdrawal_insufficientBalance_throwException() {
        // given

        // when

        // then
    }

    @Test
    public void makeWithdrawal_sufficientBalance_withdrawMade() {
        // given

        // when

        // then
    }
}
