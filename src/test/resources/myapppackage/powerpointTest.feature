@Powerpoint
Feature: PowerPointTest

  Scenario: Create and Save Powerpoint file with added slide
    Given I have opened Powerpoint
    When I save the Powerpoint file
    And I close Powerpoint
    Then Powerpoint file can be reopened

#  @ignore
#  Scenario: Create and Save Powerpoint file
#    Given I have opened Powerpoint
#    When I enter text into the Title box
#    And I enter text into the subtitle box
#    And save the Powerpoint file
#    Then the entered slide text is retained
#  @ignore
#  Scenario: Update and Save Powerpoint file
#    Given I have created and saved a Powerpoint file
#    When I update the Powerpoint file
#    And save the Powerpoint file using existing filename
#    Then the updated slide text is retained



