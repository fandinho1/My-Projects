Feature: test karate for api testing

  Background: 
    * def urlPath = 'http://restapi.demoqa.com/customer'
    * header Content-Type = 'application/json'

  Scenario: test karate method post for rest api with data json in feature
    Given url urlPath
    And path 'register'
    * def jsonData =  { "FirstName": "Juanperz", "LastName": "Renato", "UserName": "xrendezw3", "Password": "renato213", "Email": "rexeezsw3@gmaxi.com"}
    And request jsonData
    When method POST
    Then status 201
    * print response

  Scenario: test karate method post for rest api with data in json file
    Given url urlPath
    And path 'register'
    And request read('../../json/dataJsonPost.json')
    When method POST
    Then status 201
    * print response

  Scenario Outline: test karate method post for rest api with data in examples
    * set jsonData
      | path      | value         |
      | FirstName | '<FirstName>' |
      | LastName  | '<LastName>'  |
      | UserName  | '<UserName>'  |
      | Password  | '<Password>'  |
      | Email     | '<Email>'     |
    Given url urlPath
    And path 'register'
    And request jsonData
    When method POST
    Then status 201
    * print response
    * print responseStatus

    Examples: 
      | FirstName | LastName | UserName | Password | Email           |
      | Daziel    | Coras    | renaxtw4 | dasfds22 | yanksww4@gm.com |
      | Yanga     | Tapes    | cuanstw4 | regre344 | perkoww4@gm.com |

