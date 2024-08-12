@smoke
Feature: ForgetPassword | user reset his password

  Scenario: user enters valid email
    Given user go to the password recovery page
    When user enters email "testRegister2@gmail.com" and clicks on the recover button
    Then a message will be displayed that an email has been sent to the user

  Scenario: user enters invalid email
    Given user go to the password recovery page
    When user enters email "unregistered@gmail.com" and clicks on the recover button
    Then a message will be displayed that the email can't be found