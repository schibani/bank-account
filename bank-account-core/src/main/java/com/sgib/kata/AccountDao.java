package com.sgib.kata;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {

    public boolean isBalanceSufficient(long amount){
        return getAccount().getBalance() >= amount;
    }

    public Account getAccount(){
        // in real life, we get the account from external source (database, ...)
        return new Account();
    }
}
