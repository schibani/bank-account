package com.schibani.bankaccount;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class AccountDao {

    // in the real life, a class DAO must be stateless
    private Account account;

    @PostConstruct
    public void init() {
        account = new Account();
    }

    public void init(long initialBalance) {
        account = new Account(initialBalance);
    }

    public Account getAccount() {
        // in the real life, we get the account from external source (database, ...)
        return account;
    }
}
