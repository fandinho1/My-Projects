Feature: Service Rest put
  As an user
  I want update a user in a page

  Scenario Outline: Verify that the employee information is successfully updated
    Given url 'http://dummy.restapiexample.com/api/v1/update/4710'
    When request { "name":<name>, "age":<age>, "salary":<salary>  }
    And method put
    Then status 200
    And print 'Response is: ', response

    ## And match response == {"name":"Lucho","age":"24","salary":"1123"}
    Examples: 
      | name    | age | salary |
      | Lucho   |  24 |   1123 |
      | prueba2 |  40 |  24523 |
