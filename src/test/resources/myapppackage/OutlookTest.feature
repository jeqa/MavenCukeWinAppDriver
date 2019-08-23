@outlook
Feature: OutlookTest

  Scenario: Open Outlook and send mail
    Given I have opened Outlook
    When I click the New Email button
    And The user composes the E-mail
    Then the User can send the e-mail to the recipient and confirm the email has been received

  @ignore
  Scenario: Open Outlook and create Calendar entry
    Given I have opened Outlook
    When I click the Calendar button
    And I click the new appointment button
    And the user completes the calendar invite