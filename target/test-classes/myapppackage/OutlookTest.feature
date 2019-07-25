@Outlook
  Feature: OutlookTest

    Scenario: Open Outlook and send mail
      Given I have opened Outlook
      When I click the New Email button
      And A User Enters some text into an email
      Then the User can send the e-mail the recipient
