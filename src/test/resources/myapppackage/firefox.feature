@firefox
Feature: FirefoxTest

  Scenario: Firefox home page
    Given that Firefox has opened
    Then the expected home page is displayed in Firefox

  Scenario: Firefox navigate to other site
    Given that Firefox has opened
    When I attempt to navigate to another site in Firefox
    Then the expected site is displayed in Firefox
