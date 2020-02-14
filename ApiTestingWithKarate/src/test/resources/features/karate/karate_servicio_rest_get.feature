Feature:

  Background:
    * def urlPath = 'http://restapi.demoqa.com/utilities/weather/city'


  Scenario: test Get method with Karate
    Given url urlPath
    And path 'Hyderabad'
    When method GET
    Then status 200