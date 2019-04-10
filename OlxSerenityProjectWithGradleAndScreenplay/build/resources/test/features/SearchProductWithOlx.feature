Feature: Search in Olx with data from feature
  As a user, I want to search a product in the olx search bar and applying search filters

  Background: User Searched a general product in olx search bar
    Given Lucho is in the site olx
    When he search a product in the bar search
      | play 4 |
    Then he verify that there are results

  @SmokeTest
  Scenario Outline: Search a specific product in olx using all filters
    Given Lucho applies filters to search results
      | department   | city   | category   | subCategory   | minPrice   | maxPrice   |
      | <department> | <city> | <category> | <subCategory> | <minprice> | <maxPrice> |
    When he search the specific product "<specificSearch>"
    Then he verify that the product "<expectedValue>" is loaded

    Examples: 
      | department | city     | category                | subCategory  | minprice | maxPrice | specificSearch   | expectedValue    |
      | antioquia  | medellin | Video juegos - Consolas | Video juegos |      100 |   100000 | Fifa 18 Ps4      | Fifa 18 Ps4      |
      | antioquia  | medellin | Video juegos - Consolas | Video juegos |      100 |   100000 | SuperMega play4k | SuperMega play4k |

  @AlternTest
  Scenario Outline: Search a random product in olx using filters: department, category
    Given Lucho applies department and category filters to search results
      | department    | category    |
      | <department2> | <category2> |
    When he search a random product
    Then he verify that the product is loaded

    Examples: 
      | department2 | category2               |
      | antioquia   | Video juegos - Consolas |
