package com.sgib.kata;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {

    public void makeDeposit(final long amount){
        getAccount().incrementBalance(amount);
    }

    public Account getAccount(){
        return new Account();
    }
}
