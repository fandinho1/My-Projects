/// <reference types ="cypress"/>

describe("Dependent combo box page to test selects", ()=>{
    it("Testing dependent selects", ()=>{
        cy.visit("https://testingqarvn.com.es/combobox-dependiente/")
        cy.get("select#wsf-1-field-61").select("Linux").should('have.value','Linux').then(()=>{
            cy.get("select#wsf-1-field-64").select("Debian").should('have.value','Debian')
        })
        cy.wait(3000)
    })

    it("Testing text in an element", ()=>{
        cy.visit("https://testingqarvn.com.es/combobox-dependiente/")
        cy.get("#wsf-1-label-60-row-1").then((textValue)=>{
                expect(textValue).to.have.text("CypressIO")
        })
        cy.wait(3000)
    })

    it("Testing css values", ()=>{
        cy.visit("https://testingqarvn.com.es/combobox-dependiente/")
        cy.document().should("have.property","charset").and("eq","UTF-8")
        cy.get("input[placeholder='Nombre:']").should("have.css","height","39px").and("have.css","font-size","14px").and("have.css","padding","8.5px 10px")

        cy.wait(3000)
    })
})