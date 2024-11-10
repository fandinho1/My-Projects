import { Locator, Page } from "@playwright/test";

export class ProductDetailsPage{

    readonly page: Page;
    readonly addToCart: Locator;

    constructor(page: Page){
        this.page=page;
        this.addToCart = page.locator('.purchase-button');

    }

    async addProductToCart(){
        await this.addToCart.click();
    }


}