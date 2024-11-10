import { expect, Locator, Page } from "@playwright/test";

export class CartPage{

    readonly page: Page;
    private productName: Locator;
    private productPrice: Locator;
    private allProductsName: Locator;

    constructor(page:Page){
        this.page=page;
        const productContainer = page.locator('.product').first();
        this.productName = productContainer.locator('.product-description').locator('div').first();
        this.productPrice = productContainer.locator('.product-description').locator('.price');
        this.allProductsName = page.locator('.product').locator('.product-description').locator('div:first-child');
    }

    setProduct(product:string){
        const productContainer= this.page.locator('.product', {hasText: product});
        this.productName = productContainer.locator('.product-description').locator('div').first();
        this.productPrice = productContainer.locator('.product-description').locator('.price');
    }

    async verifyProductInCart(expectedProduct: string){
        await expect(this.productName.textContent()).resolves.toContain(expectedProduct);
    }

    async verifyProductsInCart(expectedProducts:string[]){
        await this.page.waitForTimeout(5000);
        await expect(this.allProductsName).toContainText(expectedProducts);
    }


}