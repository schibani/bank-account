package com.schibani.kata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.schibani.kata.Utils.MAX_DEPOSIT_AMOUNT_ALLOWED;

@Service
public class AccountService {

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
        account.addDepositOperation(amount);
    }

    public void makeWithdraw(final long amount){
        if(amount <= 0){
            throw new AccountException("the amount for a withdrawal must be positive");
        }

        final boolean balanceSufficient = accountDao.isBalanceSufficient(amount);

        if(!balanceSufficient){
            throw new AccountException(String.format("insufficient balance for a withdrawal of %s. Please contact your adviser", amount));
        }

        final Account account = accountDao.getAccount();
        account.addWithdrawalOperation(amount);
    }

    public AccountStatment getAccountStatment(final ZonedDateTime from, final ZonedDateTime to) {

        final Account account = accountDao.getAccount();

        final List<String> statments = account.getOperations().stream()
                .filter(operation -> operation.isOperationInPeriod(from, to))
                .map(operation -> operation.getPretyFormat())
                .collect(Collectors.toList());
        return new AccountStatment(statments);
    }
}
