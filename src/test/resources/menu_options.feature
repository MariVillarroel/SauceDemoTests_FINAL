Feature: Menu options functionality

  Background: User is logged in
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    Then The home page should be displayed

  Scenario: Verify menu options are displayed
    When I click on the menu button
    Then The menu options should be displayed

  Scenario: Navigate to About page from menu
    When I click on the menu button
    And I select the "About" option from menu
    Then I should be redirected to the Sauce Labs website
    And I go back to the inventory page

  Scenario: Logout from menu
    When I click on the menu button
    And I select the "Logout" option from menu
    Then I should be redirected to the login page

  Scenario: Reset app state from menu
    Given I add the "Sauce Labs Backpack" to the cart
    And The cart icon should show "1" item
    When I click on the menu button
    And I select the "Reset App State" option from menu
    Then The cart should be empty
    And I should remain on the home page