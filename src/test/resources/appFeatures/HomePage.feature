Feature: Select products.
  As a login user.
  I want to select products to buy it.
  So that I can select the products.

  Scenario: Select the products that want buy.
    Given I am on the home page
    When I select the add to cart button of the product
    Then I should be the number of products selected on the cart icon

  Scenario: Select the cart icon to navigate from cart page.
    Given I am on the home page
    And I have added products on the cart
    When I select the cart icon
    Then I should be navigate to the cart page