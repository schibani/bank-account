Feature: US3 - account statment

  Scenario: account statment with deposits and withdrawals
    Given Initial balance is 1000
    When I make a withdrawal of amount 400 from my account
    And I make a deposit of amount 150 in my account
    And I make a withdrawal of amount 250 from my account
    And I make a deposit of amount 80 in my account
    Then My new balance is 580
    And My account statment contains lines
    |Withdrawal  400  600|
    #|Deposit  150  750|
