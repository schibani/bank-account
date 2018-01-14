package com.sgib.kata;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {

    public void makeDeposit(final long amount){
        getAccount().incrementBalance(amount);
    }

    public void makeWithdraw(final long amount){
        getAccount().decrementBalance(amount);
    }

    public boolean isBalanceSufficient(long amount){
        return getAccount().getBalance() >= amount;
    }

    public Account getAccount(){
        // in real life, we get the account from external source (database, ...)
        return new Account();
    }
}
