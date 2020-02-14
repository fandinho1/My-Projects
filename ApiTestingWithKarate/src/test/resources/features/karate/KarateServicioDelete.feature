Feature:

	Background: 
	* def urlPathGet = 'https://gorest.co.in/public-api/users'
	* def urlPathDelete = 'https://gorest.co.in//public-api/users/'
	* def bearerToken = 'XOk1fXGc6w8yWsPEHcG7-zcTtcokxyQ9smPs' 
	* def idUser = 31


	@RecuperarUsuarios
	Scenario: Get en pagina GoRest.co.in, debe usar un token Barens
	
	Given url urlPathGet 
	And header Authorization = 'Bearer ' + bearerToken
	When method get
	And print response 
	Then status 200
	 
	@BorrarUnUsuario
	Scenario: Get en pagina GoRest.co.in, debe usar un token Barens
	
	
	Given url urlPathDelete
	And path idUser 
	And header Authorization = 'Bearer ' + bearerToken
	When method delete
	And print response 
	Then status 200
	And print responseStatus
	And match response._meta.code == 204 
	
	
	