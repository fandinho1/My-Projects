Feature: Practice form
  As a user I want to fill the practice form and verify the form is submitted

  @smokeTest
  Scenario Outline: Submit the practice form with all fields correctlly
    Given the user is on demoqa home page
    When he go to forms option
    And he submit the practice form with all fields
      | firstName   | lastName   | email   | gender   | mobile   | dateOfBirth   | subjects   | hobbies   | picture   | currentAddress   | state   | city   |
      | <firstName> | <lastName> | <email> | <gender> | <mobile> | <dateOfBirth> | <subjects> | <hobbies> | <picture> | <currentAddress> | <state> | <city> |
    Then he should see the practice form was submitted correctly

    Examples: 
      | firstName | lastName | email          | gender | mobile     | dateOfBirth | subjects                         | hobbies              | picture   | currentAddress      | state     | city      |
      | Luis      | Test     | test@test.com  | Male   | 1111111111 | 01-01-2000  | English                          | Sports,Reading,Music | test.png  | street 52d Nro 7d-3 | Haryana   | Panipat   |
      | Sofy      | Test2    | test2@test.com | Female | 3111231132 | 03-17-2001  | Economics,Computer Science,Maths | Reading              | test.png  | street 1a Nro 1c-3  | NCR       | Gurgaon   |
      | Carlos    | Test3    | test3@test.com | Other  | 3123342423 | 12-21-1997  | Arts,Social Studies              | Sports,Music         | test2.png | street 52d Nro 7d-3 | Rajasthan | Jaiselmer |
