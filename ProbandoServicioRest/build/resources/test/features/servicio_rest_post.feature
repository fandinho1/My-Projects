Feature: Service Rest post
  As a user
  I want register a consumer in a page

  @ServicePost
  Scenario Outline: Register user example
    Given Luis wants to register to the page customer
    When he must enter the information to register
      | name   | LastName   | userName   | password   | email   |
      | <name> | <lastname> | <nickname> | <password> | <mail> |
    Then the status code of the page is <code>

    Examples: 
      | name | lastname | nickname | password | mail                | code |
      | Luis | Fandinho | Ejemplo1 |   123456 | ejemplo@example.com |  201 |
