@smoke
Feature: Wishlist | check wishlist functionality

  Scenario: User adds item to wishlist
    When user clicks on Add to wishlist button
    Then success message appears

  Scenario: Check that a product has been added to wishlist
    When user clicks on Add to wishlist button
    And success message has disappeared
    And user clicks on wishlist tab
    Then the quantity of the product on the wishlist will be bigger than 0
