Feature: AdminLogin
  In order to blah
  As a somebody
  I want to do something

  Background:
    Given I am on the Login Page


  Scenario: Admin Login
    Given I have entered a valid Username
    And I have entered a valid Password
    When I select SignIn
    Then the Admin Landing Page is displayed

  Scenario: Admin Login Invalid Password
    Given I have entered a valid Username
    And I have entered an invalid Password
    When I select SignIn
    Then a login error message is displayed

  Scenario: Admin Login Again
    Given I have entered a valid Username
    And I have entered a valid Password
    When I select SignIn
    Then a login error message is displayed

  Scenario Outline: Admin Login Outline
    Given I have entered a valid username of "<Username>"
    And I have entered a valid password of "<Password>"
    When I select SignIn
    Then the Admin Landing Page is displayed

    Examples:
      | Username | Password             |
      | tomsmith | SuperSecretPassword! |
      | archie   | SuperSecretPassword  |