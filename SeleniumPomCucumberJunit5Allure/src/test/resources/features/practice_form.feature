
Feature: Practice form
  As a user I want to fill the practice form and verify the form is submitted

  @smokeTest
  Scenario Outline: Submit the practice form with all fields correctlly 	
    Given the user is on demoqa home page
    When he go to forms option
    And he submit the practice form with all fields
    Then he should see the practice form was submitted correctly

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
