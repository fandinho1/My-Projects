Feature: Cart feature

  Scenario: Add one product to cart successfully
    Given the user is on chairs page
    When he add the chair 'Black Shell Chair' to the cart
    Then he should see the selected chair in the cart

  Scenario: Add multiple products to cart successfully
    Given the user is on chairs page
    When he add the followings chairs to the cart
      | Wicker Chair        |
      | Wooden Stools       |
      | Plastic White Chair |
    Then he should see all the selected chairs in the cart
