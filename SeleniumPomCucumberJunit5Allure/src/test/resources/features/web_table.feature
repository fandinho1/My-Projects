@tag
Feature: Web Table
  As a user I want to add/modify/delete data from the web table

  @test
  Scenario: Add new row to web table correctly using json file
    Given the user is on demoqa home page
    When he go to web table option
    And he add a new row in the table using data from json file 'WebTableData.json'
    Then he should see a new row in the table with the correct data
