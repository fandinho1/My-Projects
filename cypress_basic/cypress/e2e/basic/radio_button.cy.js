/// <reference types = "cypress"/>

describe("Form with Checkbox fields and radio button to test", ()=>{
    it("Verifyng checkbox fields", ()=>{
        cy.visit("https://testingqarvn.com.es/radio-buttons/")
        cy.get("input[placeholder='Nombre:']").type("Luis").tab().type("Fandiño")
        cy.get("input[placeholder='Email']").should('be.visible').should('be.empty').type("email@gmail.com")
        cy.wait(1000)
        cy.xpath("//input[@value='PHP']").should('not.be.checked').click({force:true}).should('be.checked')
        //cy.xpath("//label[text()='PHP']").should('not.be.checked').click()
        cy.wait(1000)
        cy.xpath("//input[@value='PYTHON']").should('not.be.checked').check({force:true}).should('be.checked')
        cy.wait(1000)
        cy.xpath("//label[text()='JS']").should('not.be.checked')     
        cy.get("button[type='submit']").should('be.enabled').click()
        cy.wait(3000)
    })

    it("Verifyng radio buttons", ()=>{
        cy.visit("https://testingqarvn.com.es/radio-buttons/")
        cy.get("input[value='CypressIO']").should('not.be.checked').check({force:true}).should('be.checked')
        cy.get("input[value='WebdriverIO']").should('not.be.checked').check({force:true}).should('be.checked')
        cy.get("input[value='Selenium']").should('not.be.checked')
        cy.get("input[value='CypressIO']").should('not.be.checked')
        cy.wait(3000)
    })
})