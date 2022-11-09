/// <reference types= "cypress"/>

describe("alerts",()=>{

    beforeEach(()=>{
        cy.visit("https://demoqa.com/alerts")
    })

    it("Testing confirm alerts",()=>{        
        cy.get("#confirmButton").should("be.visible").click()
        cy.on("window:confirm", (alert) => {
            //verify text on pop-up
            expect(alert).to.equal("Do you confirm action?");
         });
         cy.get("#confirmResult",{timeout:10000}).should("have.text","You selected Ok")
    })

    it("Testing cancel alerts",()=>{
        cy.get("#confirmButton").should("be.visible").click()

        cy.on("window:confirm", () => {
            //cancel alert
            return false
         });
         cy.get("#confirmResult",{timeout:8000}).should("have.text","You selected Cancel")
    })
})