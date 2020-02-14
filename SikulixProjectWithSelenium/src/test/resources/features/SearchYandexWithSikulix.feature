@SmokeTest
Feature: Search in Yandex
  I want to search a word in yandex

  @tag1
  Scenario: successfull search in yandex
    Given Lucho is on yandex home page
    When he does the search
    Then he validates successful result
