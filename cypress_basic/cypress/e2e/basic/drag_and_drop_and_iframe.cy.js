/// <reference types = "cypress"/>

describe("Demo page to test drag and drop", () => {
    Cypress.on('uncaught:exception', (err, runnable) => {
        // returning false here prevents Cypress from
        // failing the test
        return false
    })

    it("Test drag and drop", () => {
        cy.visit("https://www.globalsqa.com/demo-site/draganddrop/")
        /*
               cy.get("iframe[class='demo-frame lazyloaded']").its("0.contentDocument.body").within(()=>{
                cy.log("estoy dentro")
                cy.get("#gallery img[alt='The peaks of High Tatras']").drag("#trash")                
               })
               */
        cy.getIframeDom("iframe[class='demo-frame lazyloaded']").within(() => {
            cy.xpath("//img[@alt='The peaks of High Tatras']/parent::li//a[@title='Delete this image']").click()
            cy.wait(2000)
            cy.get("#gallery img[alt='On top of Kozi kopka']").drag("#trash",{force:true})
            cy.wait(7000)
            cy.get("#gallery img[alt='The chalet at the Green mountain lake']").drag("#trash",{force:true})
            
        })
        cy.wait(3000)
    })
})