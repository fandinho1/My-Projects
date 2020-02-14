#Author: eabril@qvision.com.co
Feature: 
    sample karate test script that includes SOAP calls
    to the following demo service:
    http://www.webservicex.com/stockquote.asmx?op=GetQuote

Background:
* def urlPath = 'http://www.thomas-bayer.com/axis2/services/BLZService'

Scenario: soap 1.1
Given url urlPath
And request
"""
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:blz="http://thomas-bayer.com/blz/">
   <soapenv:Header/>
   <soapenv:Body>
      <blz:getBank>
         <blz:blz>39060180</blz:blz>
      </blz:getBank>
   </soapenv:Body>
</soapenv:Envelope>
"""
When soap action urlPath + '/getBank'
Then status 200
And match /Envelope/Body/getBankResponse/details//bezeichnung == 'Aachener Bank'
And print response 
 

