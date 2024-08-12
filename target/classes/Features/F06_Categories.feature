@smoke
Feature: Categories | user hover on category and choose a category or a subcategory

  Scenario: user hover on category and choose a category or a subcategories
    When user hover on category
    And user selects a category or one of the subcategories
    Then the category or subcategory page will open