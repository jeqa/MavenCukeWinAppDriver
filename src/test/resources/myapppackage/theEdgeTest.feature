@edge
Feature: EdgeTest

  Scenario: Edge home page
    Given that Edge has opened
    Then the expected home page is displayed in Edge

  Scenario: Edge navigate to other site
    Given that Edge has opened
    When I attempt to navigate to another site in Edge
    Then the expected site is displayed in Edge
