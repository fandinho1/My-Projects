Feature: Service Soap
  As a user
  I want to perform an operation

  Scenario Outline: Making an operation in the service
    Given that Luis wants make an operation
    When he performs the <operation> of two numbers <numUno> y <numDos>
    Then he will see the result of the sum is <expectedValue>

    Examples:
      | numUno | numDos | operation | expectedValue |
      | 5      | 2      | Add       | 7             |
      | 5      | 2      | Subtract  | 3             |
      | 10     | 2      | Multiply  | 20            |
      | 10     | 2      | Divide    | 5             |