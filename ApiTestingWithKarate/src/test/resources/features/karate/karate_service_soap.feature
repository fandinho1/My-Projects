Feature: test soap end point

  Background: 
    #    * url demoBaseUrl + '/soap'
    # this live url should work if you want to try this on your own
    * def urlX = 'http://www.dneonline.com/calculator.asmx'
    * header Content-Type = 'text/xml'

  Scenario Outline: soap service
    Given url urlX + '?op=<operation>'
    And request
      """
      <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:tem="http://tempuri.org/">
         <soapenv:Header/>
         <soapenv:Body>
            <tem:<operation>>
               <tem:intA><numOne></tem:intA>
               <tem:intB><numTwo></tem:intB>
            </tem:<operation>>
         </soapenv:Body>
      </soapenv:Envelope>
      """
    #When soap action 'http://www.dneonline.com/calculator.asmx?op=Add'
    When method post
    Then status 200
    And match /Envelope/Body/<operation>Response/<operation>Result == <expectedResult>
    And print 'response: ', response

    Examples: 
      | numOne | numTwo | expectedResult | operation |
      |      7 |      3 |             10 | Add       |
      |      5 |      3 |             15 | Multiply  |
