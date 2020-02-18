Feature: As a tester I want to test the api cats

  Background:
    Given header Content-Type = 'application/json'
    And header x-api-key = 'DEMO-API-KEY'
    * def urlPath = 'https://api.thecatapi.com/'
    * def breedPath = 'v1/images/search?breed_ids='
    * def votesPath = 'v1/votes'

  Scenario Outline: get the breed of cats
    Given url urlPath + breedPath + '<breed>'
    When method GET
    Then status 200
    And match response.[0].breeds[0].id == "beng"
    Examples:
      | breed |
      | beng  |

  Scenario: get all the votes
    Given url urlPath
    And path votesPath
    When method GET
    Then status 200
    And match response == '#array'
    And assert response.length <= 100

  Scenario Outline: Make a new vote
    * set jsonData
      | path     | value       |
      | image_id | '<imageId>' |
      | sub_id   | '<subId>'   |
      | value    | '<value>'   |
    Given url urlPath
    And path votesPath
    And request jsonData
    When method POST
    Then status 200
    And match response.message == 'SUCCESS'
    Examples:
      | imageId | subId         | value |
      | asf2    | my-user-12344 | 1     |

  Scenario Outline: Delete a vote
    Given url urlPath
    And path votesPath + '/<idVote>'
    When method DELETE
    Then status 200
    And match response.message == 'SUCCESS'
    Examples:
      | idVote |
      | 173338 |

    