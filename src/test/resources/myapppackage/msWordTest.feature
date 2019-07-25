@Word
Feature: WordTest

  Scenario: Create and Save Word Document
    Given I have opened Word
    When I enter text
    And save the document
    Then the entered text is retained

  Scenario: Update and Save Word Document
    Given I have created and saved a Word Document
    When I update the text
    And save the document using existing filename
    Then the updated text is retained