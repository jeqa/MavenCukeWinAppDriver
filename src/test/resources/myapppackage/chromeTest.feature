@Chrome
Feature: ChromeTest

#  Scenario: Chrome app check
##    Then Chrome is opened as expected

  Scenario: Chrome home page
    Then the expected home page is displayed

  Scenario: Chrome navigate to other site
    When I attempt to navigate to another site
    Then the expected site is displayed
