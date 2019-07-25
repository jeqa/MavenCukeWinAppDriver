@Outlook
  Feature: OutlookTest

    Scenario: Open Outlook and send mail
      Given I have opened Outlook
      When I click the New Email button
      And A User Enters some text into an email
      Then the User can send the e-mail the recipient
#  Examples:
#        |                 text                   |
#        |"This Text can be altered in the Feature file" |

#      Then I will have successfuly sent an E-mail
#
#    Scenario: Create Mail and save as draft
#      Given I have opened Outlook
#      When I click the new Email button
#      And Enter some text
#      Then I can save the email as a draft
#
#    Scenario: Send meeting invite
#      Given I have opened Outlook
#      When I click on meetings
#      And Create a new meeting
#      And Enter some text
#      And Enter a date and time for the meeing
#      Then I have sent a meeting request successfuly