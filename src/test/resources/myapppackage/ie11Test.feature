@ie11
Feature: IETest

  Scenario: IE11 home page
    Given that IE has opened
    Then the expected home page is displayed in IE

  Scenario: IE11 navigate to other site
    Given that IE has opened
    When I attempt to navigate to another site in IE
    Then the expected site is displayed in IE
