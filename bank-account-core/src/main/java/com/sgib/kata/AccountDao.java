package com.sgib.kata;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {

    public void makeDeposit(final long amount){
        getAccount().incrementBalance(amount);
    }

    private Account getAccount(){
        return new Account();
    }
}
