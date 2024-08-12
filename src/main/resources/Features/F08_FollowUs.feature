@smoke
Feature: FollowUs | check the functionality for followUp buttons

  Scenario: user opens facebook link
    When user clicks on facebook button
    Then "https://www.facebook.com/nopCommerce" is opened in new tab

  Scenario: user opens twitter link
    When user clicks on twitter button
    Then "https://twitter.com/nopCommerce" is opened in new tab

  Scenario: user opens rss link
    When user clicks on rss button
    Then "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab


  Scenario: user opens youtube link
    When user clicks on youtube button
    Then "https://www.youtube.com/user/nopCommerce" is opened in new tab