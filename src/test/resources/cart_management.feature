Feature: Cart management - Continue shopping

  Background: User is logged in with items in cart
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    And The home page should be displayed
    And I add the "Sauce Labs Backpack" to the cart
    And I click on the cart icon

  Scenario: Continue shopping from cart
    When I click on the continue shopping button
    Then I should be redirected to the home page
    And I should be able to add another product to cart