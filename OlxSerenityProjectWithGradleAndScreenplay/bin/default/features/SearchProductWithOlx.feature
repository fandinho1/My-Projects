Feature: Search in Olx with data from feature
  As a user, I want to search products in the olx search bar applying filters

  @SmokeTest
  Scenario Outline: Search a product in olx with filters
    Given Lucho search the product "<generalSearch>" in the bar search
    When he applies filters to search results
      | department   | city   | category   | subCategory   | minPrice   | maxPrice   |
      | <department> | <city> | <category> | <subCategory> | <minprice> | <maxPrice> |
    And he search the specific product "<specificSearch>"
    Then he verify that the product "<expectedValue>" is loaded

    Examples: 
      | generalSearch | department | city     | category                | subCategory  | minprice | maxPrice | specificSearch   | expectedValue    |
      | play 4        | antioquia  | manizales34 | Video juegos - Consolas | Video juegos |      100 |   100000 | Fifa 18 Ps4      | Fifa 18 Ps4      |
      | play 4        | antioquia  | medellin | Video juegos - Consolas | Video juegos |      100 |   100000 | SuperMega play4k | SuperMega play4k |
