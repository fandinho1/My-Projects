Feature: Search in Google with data from feature
  I want to search a word in google

  @SmokeTest
  Scenario Outline: Search in yahoo
    Given Goku is in the site yahoo
    When He search the word "<word>"
    Then He verify that the word "<expectedValue>" is in the results

    Examples: 
      | word             | expectedValue    |
      | hola             | hola             |
      | sophos solutions | sophos solutions |
      | perro            | perro2           |
