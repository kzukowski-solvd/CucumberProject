Feature: Order Placement
  Scenario: Successful order placement
    Given I am on the login page
    When I log in with username "standard_user" and password "secret_sauce"
    And I add the first and second items to the cart
    And I proceed to checkout
    And I fill in the details with first name "a", last name "a", and postal code "a"
    And I complete the order
    Then I should see the header "Thank you for your order!"

