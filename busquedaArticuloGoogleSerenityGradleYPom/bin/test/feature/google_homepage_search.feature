# language: en
Feature: Google Homepage Search

  Scenario Outline: User can search with “Google Search” for anything
    Given The user is on the homepage
    When He type <phrase> into the search field
    And He click the Google Search button
    Then He go to the search results page
    And the first result is <expectedValue>

    Examples:
      | phrase               | expectedValue                           |
      | The name of the wind | The Name of the Wind - Patrick Rothfuss |