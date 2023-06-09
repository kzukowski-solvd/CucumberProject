
Feature: Order Placement
  Scenario: Successful order placement
    Given a user with ID 2
    When the user logs in with valid credentials
    And the user navigates to the product list page
    And the user adds the matching products to the cart
    And the user proceeds to checkout
    And the user fills in the shipping details with:
      | First Name | Last Name | Address |
      | a | a | a |
    And the user completes the order
    Then the user sees the header message "Thank you for your order!"