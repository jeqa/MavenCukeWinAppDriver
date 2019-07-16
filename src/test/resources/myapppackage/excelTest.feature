@Excel
Feature: ExcelTest

  Scenario: Create and Save Excel Document
    Given I have opened Excel
    When I enter text into cell B4
    And save the document
    Then the entered text is retained in cell B4

  Scenario: Update and Save Excel Document
    Given I have created and saved a Excel Document
    When I update by entering text into cell D9
    And save the document using existing filename
    Then the updated text is retained in Cell D9