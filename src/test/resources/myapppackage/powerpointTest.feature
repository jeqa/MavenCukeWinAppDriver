@Powerpoint
Feature: PowerPointTest

  Scenario: Create and Save Powerpoint file
    Given I have opened Powerpoint
    When I enter text into the Title box
    And I enter text into the subtitle box
    And save the Powerpoint file
    Then the entered slide text is retained
