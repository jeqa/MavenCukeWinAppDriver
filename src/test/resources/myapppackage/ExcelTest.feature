@Excel
Feature: ExcelTest

  Scenario: Create and Save Excel Document
    Given I have opened a blank workbook
    When I enter text into a cell
      |B4|
    And save the workbook
    Then the entered text is retained in the expected cell

  Scenario: Update and Save Excel Document
    Given I have created and saved a Excel Document
      |B4|
    When I update by entering text into another cell
      |D9|
    And save the workbook using existing filename
    Then the updated text is retained in the expected cell