@ignore

Feature: NotepadTest

  Scenario: Create and Save Notepad text file
    Given I have opened Notepad
    When I enter text into the text file
    And save the text file
    Then the entered text is retained in the text file

  Scenario: Update and Save Notepad text file
    Given I have created and saved a text file
    When I update the text file
    And save the text file using existing filename
    Then the updated text is retained in the text file


