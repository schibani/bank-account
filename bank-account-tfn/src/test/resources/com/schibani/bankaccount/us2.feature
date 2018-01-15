Feature: US2 - making withdrawal

  Scenario: single withdrawal
    Given Initial balance is 500
    When I make a withdrawal of amount 200 from my account
    Then My new balance is 300

  Scenario: multiple withdrawals
    Given Initial balance is 450
    When I make a withdrawal of amount 30 from my account
    And I make a withdrawal of amount 20 from my account
    Then My new balance is 400