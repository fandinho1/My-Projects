/// <reference types= "cypress"/>

describe("Page to test mouse over and target blank",()=>{

    it("Test of mouse over and target blank",()=>{
        cy.visit("https://testingqarvn.com.es/")
        cy.get("a").contains("Cursos").trigger('mouseover')
        cy.get("a").contains("Cypress IO").click()
        cy.get("a").contains("Ir al Curso completo").first().invoke("removeAttr","target").click()
        cy.wait(3000)
    })
})