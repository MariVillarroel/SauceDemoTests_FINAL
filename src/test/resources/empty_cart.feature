Feature: Checkout with empty cart

  Background: User is logged in
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    Then The home page should be displayed

  Scenario: Try to checkout with empty cart
    When I click on the cart icon
    And I click on the checkout button
    Then I should remain on the cart page
    And An error message should be displayed