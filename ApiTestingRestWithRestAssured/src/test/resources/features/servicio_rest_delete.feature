Feature: Service Rest delete
  As an user
  I want delete an user in a page

  @ServicePost
  Scenario Outline: delete user example
    Given Luis wants to delete an user in the page dummy with id
    When he must enter the id <idEmpleado> of employe to be deleted
    Then the status code of the page will be <code>

    Examples: 
      | idEmpleado | code |
      |      15410 |  200 |
