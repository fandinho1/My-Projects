/// <reference types= "cypress"/>

describe("Iterate in a list of elements",()=>{

    it("Test of for each",()=>{
        cy.visit("https://demoqa.com/books")
        let products = []
        cy.get(".rt-tbody a").each(($el)=>{
                products.push($el.text())
                /*
                cy.get($el).click({force:true})
                cy.contains("button","Back To Book Store").click()
                */
        })
        .then(()=>{
           /* products.forEach(element =>{
                cy.get(".rt-tbody a").contains(element).click({force:true})
                cy.click
                cy.contains("button","Back To Book Store").click()
            })*/

            cy.get(".rt-tbody a").contains(products.find(element => element =="Speaking JavaScript")).click()
            cy.contains("button","Back To Book Store").click()
        })
    })
})