@Calculator
Feature: CalculatorTest

  Scenario: Calculator addition
    Given I have opened Calculator
    When I select 1
    And I select Plus
    And I select 7
    And I select Equals
    Then the expected answer is 8

  Scenario: Calculator division
    Given I have opened Calculator
    When I select 8
    And I select Divide
    And I select 2
    And I select Equals
    Then the expected answer is 4

  Scenario: Calculator minus
    Given I have opened Calculator
    When I select 9
    And I select Minus
    And I select 3
    And I select Equals
    Then the expected answer is 6

  Scenario: Calculator multiply
    Given I have opened Calculator
    When I select 3
    And I select Multiply
    And I select 3
    And I select Equals
    Then the expected answer is 9