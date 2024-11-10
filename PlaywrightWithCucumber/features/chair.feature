Feature: Chairs Feature

  Scenario: Verify a chair with status Sold out
    Given the user is on chairs page
    When he see the chair 'Upholstered Black Barstool'
    Then he should see the status 'Sold out'

  Scenario Outline: Verify a chair with status In Stock
    Given the user is on chairs page
    When he see the chair '<chairName>'
    Then he should see the status 'In stock'

    Examples:
      | chairName         |
      | Wicker Chair      |
      | Black Shell Chair |
      | Wooden Stools     |
