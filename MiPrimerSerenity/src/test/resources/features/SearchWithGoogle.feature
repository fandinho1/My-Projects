#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Search in Google with data from feature
  I want to search a word in google

  @SmokeTest
  Scenario Outline: Search in google
    Given He is in the site google
    When He search the word "<word>" 
    Then He verify that the word "<word>" is in the results

    Examples: 
      | word             |
      | hola             |
      | sophos solutions |
      | perro            |
