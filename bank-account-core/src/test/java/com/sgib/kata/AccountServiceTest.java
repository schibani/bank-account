package com.sgib.kata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountDao accountDao;

    @Test
    public void makeDeposit_negativeAmount_throwException() {
        // given
        final long negativeAmount = -50;

        // when, then
        assertThatExceptionOfType(AccountException.class)
                .isThrownBy(() -> accountService.makeDeposit(negativeAmount))
                .withMessage("the amount for a deposit must be positive");
    }

    @Test
    public void makeDeposit_zeroAmount_throwException() {
        // given
        final long zeroAmount = 0;

        // when, then
        assertThatExceptionOfType(AccountException.class)
                .isThrownBy(() -> accountService.makeDeposit(zeroAmount))
                .withMessage("the amount for a deposit must be positive");
    }

    @Test
    public void makeDeposit_tooBigAmount_throwException() {
        // given
        final long tooBigAmount = AccountService.MAX_DEPOSIT_AMOUNT_ALLOWED + 1;

        // when, then
        assertThatExceptionOfType(AccountException.class)
                .isThrownBy(() -> accountService.makeDeposit(tooBigAmount))
                .withMessage("the maximum amount allowed for a deposit (1000) is exceeded");
    }

    @Test
    public void makeDeposit_validAmount_depositMade() {
        // given
        final long validAmount = 200;

        // when
        accountService.makeDeposit(validAmount);

        // then
        verify(accountDao).makeDeposit(validAmount);
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
