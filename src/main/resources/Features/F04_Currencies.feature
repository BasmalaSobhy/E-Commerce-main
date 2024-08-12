@smoke
Feature: Currencies | user change the currency from dollar to euro

  Scenario: user change the currency to euro
    When user selects the "Euro" currency
    Then currencies for the products will changed to "€"