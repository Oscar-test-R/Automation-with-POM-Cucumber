Feature: Login successful.
  As a user.
  I want to login with the credentials.
  So that I can login in the page.

  Scenario: Successful logout from the side menu of home page.
    Given I am on the login page
    When I enter valid credentials "standard_user" and password "secret_sauce"
    And I click on the login button
    Then message is displayed to confirm the user is on the home page

