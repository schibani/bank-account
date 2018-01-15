package com.schibani.bankaccount;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = SpringTestConfiguration.class)
public class Stepdefs {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ApplicationContext applicationContext;

    private AccountDao accountDao;

    @Before
    public void resetContext() {
        accountDao = applicationContext.getBean(AccountDao.class);
        accountDao.init();
    }

    @Given("^As a bank client$")
    public void as_a_bank_client() {
        // no thing to implement
    }

    @Given("^Initial balance is (\\d+)$")
    public void initial_balance_is(long initialBalance) {
        accountDao.init(initialBalance);
    }

    @When("^I make a deposit of amount (\\d+) in my account$")
    public void i_make_a_deposit(long amount) {
        accountService.makeDeposit(amount);
    }

    @When("^I make a withdrawal of amount (\\d+) from my account$")
    public void i_make_a_withdrawal(long amount) {
        accountService.makeWithdrawal(amount);
    }

    @Then("^My new balance is (\\d+)$")
    public void my_balance_is(long balance) {
        assertThat(accountService.getAccount().getBalance()).as("new balance").isEqualTo(balance);
    }

    @Then("^My account statment contains lines$")
    public void account_statment_lines(List<String> statments) {
        final AccountStatment accountStatment = accountService.getAccountStatment(ZonedDateTime.now().minusDays(30), ZonedDateTime.now());
        assertThat(accountStatment.getStatments()).containsAll(getDatedStatments(statments));
    }

    private List<String> getDatedStatments(List<String> statments) {
        final String today = Utils.DATE_FORMATTER.format(ZonedDateTime.now());
        return statments.stream()
                .map(s -> String.format("%s  %s", today, s))
                .collect(Collectors.toList());
    }
}
