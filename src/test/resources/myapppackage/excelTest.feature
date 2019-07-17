@Excel
Feature: ExcelTest

  Scenario: Create and Save Excel Document
    Given I have opened a blank workbook
    When I enter text into cell BFour
    And save the workbook
    Then the entered text is retained in cell BFour

  Scenario: Update and Save Excel Document
    Given I have created and saved a Excel Document
    When I update by entering text into cell D9
    And save the workbook using existing filename
    Then the updated text is retained in Cell D9