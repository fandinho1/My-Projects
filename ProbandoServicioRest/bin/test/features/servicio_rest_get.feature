Feature: Service Rest get
  As an user
  I want know a city

  @ServiceGet
  Scenario Outline: Consult city information
    Given that Luis wants to consult a city
    When she consult city <city> in the service
    Then the response of the service shows the city <city>

    Examples: 
      | city      |
      | Hyderabad |
