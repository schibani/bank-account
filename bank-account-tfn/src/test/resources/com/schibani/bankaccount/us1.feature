Feature: US1 - making deposit

  Scenario: single deposit
    Given As a bank client
    When I make a deposit of amount 150 in my account
    Then My new balance is 150

  Scenario: multiple deposits
    Given As a bank client
    When I make a deposit of amount 150 in my account
    And I make a deposit of amount 50 in my account
    Then My new balance is 200