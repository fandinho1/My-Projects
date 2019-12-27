Feature: Service Rest put
  As an user
  I want update a user in a page

  @ServicePost
  Scenario Outline: Update user example
    Given Luis wants to update a user in the page dummy with id <idEmpleado>
    When he must enter the information to update
      | name   | age   | salary   |
      | <name> | <age> | <salary> |
    Then he will see the status code of the page is <code>

    Examples: 
      | name | age | salary | idEmpleado | code |
      | Luis |  24 |  12345 |      15410 |  200 |
