@smoke
Feature: Register | user creates new account to the system

  Scenario: create new account successfully
    Given user goes to register page
    When user selects the gender
    And user enters his first "Automation" and last "Tester" name
    And user enters the date of birth
    And user enters the email "testRegister2@gmail.com"
    And user enters the password "12345_Test"
    And user confirms the password "12345_Test"
    And user clicks register button
    Then user register successfully