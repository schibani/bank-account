package com.sgib.kata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final static Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    public static long MAX_DEPOSIT_AMOUNT_ALLOWED = 1000;

    @Autowired
    private AccountDao accountDao;

    public void makeDeposit(final long amount){
        if(amount <= 0){
            throw new AccountException("the amount for a deposit must be positive");
        }

        if(amount > MAX_DEPOSIT_AMOUNT_ALLOWED){
            throw new AccountException(String.format("the maximum amount allowed for a deposit (%s) is exceeded", MAX_DEPOSIT_AMOUNT_ALLOWED));
        }

        final Account account = accountDao.getAccount();
        account.addDepositOperationAndIncrementBalance(amount);

        LOGGER.info("Deposit of {} is made with success", amount);
    }

    public void makeWithdraw(final long amount){
        if(amount <= 0){
            throw new AccountException("the amount for a withdraw must be positive");
        }

        final boolean balanceSufficient = accountDao.isBalanceSufficient(amount);

        if(!balanceSufficient){
            throw new AccountException(String.format("balance insifficient for a withdraw of %s. Please contact your adviser", amount));
        }

        final Account account = accountDao.getAccount();
        account.addWithdrawalOperationAndDecrementBalance(amount);

        LOGGER.info("Withdrawal of {} is made with success", amount);
    }
}
