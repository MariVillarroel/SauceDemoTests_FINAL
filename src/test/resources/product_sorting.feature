Feature: Product sorting functionality

  Background: User is logged in
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    Then The home page should be displayed

  Scenario: Sort products by Name (A to Z)
    When I select the "Name (A to Z)" sorting option
    Then The products should be sorted in ascending alphabetical order

  Scenario: Sort products by Name (Z to A)
    When I select the "Name (Z to A)" sorting option
    Then The products should be sorted in descending alphabetical order

  Scenario Outline: Verify default sorting is A to Z
    When The home page should be displayed
    Then The products should be sorted in ascending alphabetical order