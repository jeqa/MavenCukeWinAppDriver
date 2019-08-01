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
    When I update by entering text into cell DNine
    And save the workbook using existing filename
    Then the updated text is retained in Cell DNine