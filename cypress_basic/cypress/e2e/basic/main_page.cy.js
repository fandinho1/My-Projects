/// <reference types= "cypress"/>

describe("Main Page", ()=>{
    it.skip("verify page is up in contact button", ()=>{
        cy.visit("https://testingqarvn.com.es/")
        cy.get("a:contains('Contáctame')").type('{pageup}')
        cy.wait(3000)
    })    

    it.skip("verify page is down in contact button", ()=>{
        cy.visit("https://testingqarvn.com.es/")
        cy.get("a:contains('Contáctame')").type("{pagedown}")
        cy.wait(3000)
    })    
})