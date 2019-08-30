@chrome
Feature: ChromeTest

  Scenario: Chrome home page
    Given that Chrome has opened
    Then the expected home page is displayed

  Scenario: Chrome navigate to other site
    Given that Chrome has opened
    When I attempt to navigate to another site
    Then the expected site is displayed
