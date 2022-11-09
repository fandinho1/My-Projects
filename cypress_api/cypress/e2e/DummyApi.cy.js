/// <reference types= "cypress"/>

describe("Testing apis", () => {

    before(() => {
        cy.fixture("data_to_post").then((data) => {
            globalThis.data = data
        })
    })

    it("Method get", () => {
        cy.request({
            method: "GET",
            url: "/posts",
            headers: {
                accept: "application/json"
            }
        }).then((response) => {
            expect(response.status).to.be.eq(200)
        })
    })

    it("Method Get with and specific id", () => {
        let idEmployee = 1
        cy.request({
            method: "GET",
            url: `/posts/${idEmployee}`,
            headers: {
                accept: "application/json"
            }
        }).then((response) => {
            let datos = JSON.parse(JSON.stringify(response.body))
            expect(response.status).to.be.eq(200)
            expect(datos).to.have.property("title", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit")
            expect(datos).has.property("userId", 1)
            expect(datos).has.property("id", idEmployee)
        })
    })

    it("Method POST", () => {
        cy.request({
            method: "POST",
            url: "/posts",
            headers: {
                accept: "application/json"
            },
            body: data
        }).then((response) => {
            expect(response.status).to.be.eq(201)
        })
    })

    it("Method PUT", () => {
        cy.fixture("data_to_put").then((dataPut) => {
            cy.request({
                method: "PUT",
                url: "/posts/1",
                headers: {
                    accept: "application/json"
                },
                body: dataPut
            }).then((response) => {
                expect(response.status).to.be.eq(200)
                cy.log(JSON.stringify(response))
            })
        })
    })

    it("Method DELETE", () => {
        cy.request({
            method: "DELETE",
            url: "/posts/1",
            headers: {
                accept: "application/json"
            }
        }).then((response) => {
            expect(response.status).to.be.eq(200)
            cy.log(JSON.stringify(response))
        })
    })
})
