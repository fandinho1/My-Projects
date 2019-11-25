#languaje: es
Feature: Google Choose Link in SearchResults

  Scenario Outline: User chooses a link from the google search results
    Given The user is on the homepage
    When He type <phrase> into the search field
    And He click the Google Search button
    Then He go to the search results page
    And the first result is <expectedValue>
    When I click on the first result link
    Then I go to the <expectedFinalValue> page
    Examples:
      | phrase               | expectedValue                           | expectedFinalValue           |
      | The name of the wind | The Name of the Wind - Patrick Rothfuss | Patrick Rothfuss - The Books |

