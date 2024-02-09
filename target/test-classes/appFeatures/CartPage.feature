Scenario: Select the checkout button.
  Given I am on the cart page
  When I select the checkout button
  Then I should be navigate to the checkout page

Scenario: Select the checkout button.
  Given I am on the cart page
  When I select the remove button
  Then The product should be removed
