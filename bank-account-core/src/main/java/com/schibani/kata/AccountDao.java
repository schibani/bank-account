package com.schibani.kata;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class AccountDao {

    // in the real life,  a class DAO must be stateless
    private List<Account> accounts = Arrays.asList(new Account(), new Account(100));

    public boolean isBalanceSufficient(long amount){
        return getAccount().getBalance() >= amount;
    }

    public Account getAccount(){
        // in the real life, we get the account from external source (database, ...)
        return accounts.get(0);
    }
}
