@smoke
Feature: Login | user login to his account

  Scenario: user login with valid email and password
    Given user go to the login page
    When user enters email "testRegister2@gmail.com" and password "12345_Test"
    And user clicks on the login button
    Then user will login to his account


  Scenario: user login with invalid email and password
    Given user go to the login page
    When user enters email "unregistered@gmail.com" and password "123"
    And user clicks on the login button
    Then user won't login to his account