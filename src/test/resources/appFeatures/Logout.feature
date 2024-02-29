Feature: Logout session

  Background:
    Given user has already logged in to application with "standard_user" and password "secret_sauce"

    Scenario: Logout session
      When Clicks on the logout option in burger menu
      Then Then Redirect to the login page without credentials