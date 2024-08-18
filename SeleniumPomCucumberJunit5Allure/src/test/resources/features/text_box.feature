Feature: Text Box form
  As a user I want to fill the text box form and verify the form is submitted

  @smokeTest
  Scenario Outline: Submit the form with all fields correctlly and specific row from csv data
    Given the user is on demoqa home page
    When he go to text box inside of elements option
    And he submit the text box form with all fields of specific row from csv '<csvName>' <rowNumber>
    Then he should see the form was submitted correctly

    Examples: 
      | csvName         | rowNumber |
      | TextBoxData.csv |         0 |
      | TextBoxData.csv |         1 |
  
  @test2
  Scenario: Submit the form with all fields correctlly and all rows from csv data
    Given the user is on demoqa home page
    When he go to text box inside of elements option
    And he submit the text box form with all fields of all rows from csv 'TextBoxData.csv'

