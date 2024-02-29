Feature: Buy products.
  As a login user.
  I want to successfully buy.
  So that I can buy products.

  Background:
    Given user has already logged in to application with "standard_user" and password "secret_sauce"

  Scenario: Select the products that I buy.
    And I select products
    And I select the cart icon
    And I select the checkout button
    When I am in the checkout page fill the fields First name, Last name and Zip code
    And Select the Continue button
    And I am in the checkout overview for click in the Finish button
    Then The message is shown in the finish page


