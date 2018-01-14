package com.sgib.kata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountDao accountDao;

    @Mock
    private Account account;

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
        final long tooBigAmount = Utils.MAX_DEPOSIT_AMOUNT_ALLOWED + 1;

        // when, then
        assertThatExceptionOfType(AccountException.class)
                .isThrownBy(() -> accountService.makeDeposit(tooBigAmount))
                .withMessage("the maximum amount allowed for a deposit (1000) is exceeded");
    }

    @Test
    public void makeDeposit_validAmount_depositMade() {
        // given
        final long validAmount = 200;
        when(accountDao.getAccount()).thenReturn(account);

        // when
        accountService.makeDeposit(validAmount);

        // then
        verify(account).addDepositOperation(validAmount);
    }

    @Test
    public void makeWithdrawal_negativeAmount_throwException() {
        // given
        final long negativeAmount = -100;

        // when, then
        assertThatExceptionOfType(AccountException.class)
                .isThrownBy(() -> accountService.makeWithdraw(negativeAmount))
                .withMessage("the amount for a withdrawal must be positive");
    }

    @Test
    public void makeWithdrawal_zeroAmount_throwException() {
        // given
        final long negativeAmount = 0;

        // when, then
        assertThatExceptionOfType(AccountException.class)
                .isThrownBy(() -> accountService.makeWithdraw(negativeAmount))
                .withMessage("the amount for a withdrawal must be positive");
    }

    @Test
    public void makeWithdrawal_insufficientBalance_throwException() {
        // given
        final boolean isBalanceSufficient = false;
        when(accountDao.isBalanceSufficient(anyLong())).thenReturn(isBalanceSufficient);

        // when, then

        assertThatExceptionOfType(AccountException.class)
                .isThrownBy(() -> accountService.makeWithdraw(50))
                .withMessage("insufficient balance for a withdrawal of 50. Please contact your adviser");
    }

    @Test
    public void makeWithdrawal_sufficientBalance_withdrawMade() {
        // given
        final int validAmount = 50;
        final boolean isBalanceSufficient = true;
        when(accountDao.isBalanceSufficient(anyLong())).thenReturn(isBalanceSufficient);
        when(accountDao.getAccount()).thenReturn(account);

        // when
        accountService.makeWithdraw(validAmount);

        // then
        verify(account).addWithdrawalOperation(validAmount);
    }

    @Test
    public void getAccountStatment_betweenTwoDates_correctAccountStatment() {
        // given
        final Account account = new Account();
        account.addDepositOperation(500);
        account.addWithdrawalOperation(200);
        account.addDepositOperation(50);
        when(accountDao.getAccount()).thenReturn(account);
        final ZonedDateTime to = ZonedDateTime.now();
        final ZonedDateTime from = to.minusDays(30);
        // when
        final AccountStatment accountStatment = accountService.getAccountStatment(from, to);

        // then
        assertThat(accountStatment.getStatments())
                .contains("14/01/2018    Deposit  500  500")
                .contains("14/01/2018    Withdrawal  200  300")
                .contains("14/01/2018    Deposit  50  350");
    }

}
