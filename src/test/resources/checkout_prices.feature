Feature: Verify prices in cart vs home page

  Background: User is logged in
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    Then The home page should be displayed

  Scenario: Verify product price consistency between home page and cart
    Given I note the price of "Sauce Labs Backpack" on home page
    And I add the "Sauce Labs Backpack" to the cart
    And I click on the cart icon
    Then The price of "Sauce Labs Backpack" in cart should match the home page price

  Scenario: Verify multiple product prices in cart
    Given I note the price of "Sauce Labs Backpack" on home page
    And I note the price of "Sauce Labs Bike Light" on home page
    And I add the "Sauce Labs Backpack" to the cart
    And I add the "Sauce Labs Bike Light" to the cart
    And I click on the cart icon
    Then The price of "Sauce Labs Backpack" in cart should match the home page price
    And The price of "Sauce Labs Bike Light" in cart should match the home page price