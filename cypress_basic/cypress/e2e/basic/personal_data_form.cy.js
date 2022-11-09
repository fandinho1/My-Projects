/// <reference types = "cypress" />

describe("Personal data form", () =>{
    Cypress.on('uncaught:exception', (err, runnable) => {
        // returning false here prevents Cypress from
        // failing the test
        return false
    })

    it("My first validation in cypress", ()=>{
        cy.log("Hello World")
        cy.visit("https://testingqarvn.com.es/datos-personales/")
        cy.title().should('eq','Datos Personales | TestingQaRvn')
        cy.get("#wsf-1-field-21").type("Luis")
        cy.get("#wsf-1-field-22").type("Fandiño")
        cy.get("#wsf-1-field-23").type("email@gmail.com")
        cy.get("#wsf-1-field-24").type("12345678")
        cy.wait(1000)
        cy.get("#wsf-1-field-28").type("address")
        cy.wait(1000)
        cy.contains('Submit').should('be.enabled').click()
        cy.wait(3000)
    })
})