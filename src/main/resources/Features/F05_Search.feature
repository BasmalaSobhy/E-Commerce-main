@smoke
Feature: Search | user searches for different products

  Scenario Outline: user searches using product name
    When user enters the product name "<name>" in the search input
    And user clicks on the search button
    Then user gets the result of the search with name "<name>"

  Examples:
    | name |
    | laptop |
    | nike |

  Scenario Outline: user searches using product serial number
    When user enters the product serial number "<sku>" in the search input
    And user clicks on the search button
    Then user gets the result of the search with serial "<sku>"

  Examples:
    | sku |
    | APPLE_CAM |
    | SF_PRO_11 |
