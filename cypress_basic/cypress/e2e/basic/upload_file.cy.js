/// <reference types = "cypress"/>

describe("Upload files page", ()=>{
    const image_to_upload = "test_image_upload.jpg"

    it("Test for upload files", ()=>{
        cy.visit("https://testingqarvn.com.es/upload-files/")
        cy.get("input[type='file']").attachFile(image_to_upload)
        cy.wait(3000)
    } )
})