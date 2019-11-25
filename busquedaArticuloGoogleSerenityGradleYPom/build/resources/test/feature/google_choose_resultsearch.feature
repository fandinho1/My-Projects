#languaje: es
Feature: Google Choose Link in SearchResults

  Scenario Outline: User can search with “Google Search” for anything and he chooses a link from the google search results
    Given The user is on the homepage
    When He type <phrase> into the search field
    And He click the Google Search button
    Then He goes to the search results page
    And the first result is <expectedValue>
    When He click on the first result link
    Then He will go to the <expectedFinalValue>
    Examples:
      | phrase                       | expectedValue                           | expectedFinalValue           |
      | The name of the wind         | The Name of the Wind - Patrick Rothfuss | Patrick Rothfuss - The Books |
      | Patrick Rothfuss - The Books | Patrick Rothfuss - The Books            | Patrick Rothfuss - The Books |


  Scenario Outline: User can search with “Google Search” for anything using the suggestons list
  and he chooses a link from the google search results
    Given The user is on the homepage
    When He type <phrase> into the search field
    And He click on the first suggestion in the list displayed
    Then He goes to the search results page
    And the first result is <expectedValue>
    When He click on the first result link
    Then He will go to the <expectedFinalValue>

    Examples:
      | phrase            | expectedValue                           | expectedFinalValue           |
      | The name of the w | The Name of the Wind - Patrick Rothfuss | Patrick Rothfuss - The Books |

