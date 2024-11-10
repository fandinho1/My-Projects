import { expect, Locator, Page } from "@playwright/test";

export class ChairPage{

    private readonly page : Page;
    private chairName: Locator;
    private chairPrice: Locator;
    private stockStatus: Locator;
    private chairImg: Locator;


    constructor(page: Page){
        this.page=page
        const chairCardContainer = page.locator('.product-card-container').first();
        this.chairName = chairCardContainer.locator('.description').locator('div').first();
        this.chairPrice = chairCardContainer.locator('.description').locator('.price');
        this.stockStatus = chairCardContainer.locator('.status');
        this.chairImg = chairCardContainer.locator('img');

    }

    async verifyChairName(expectedName: string){
        await expect(this.chairName.textContent()).resolves.toEqual(expectedName);
    }

    async verifyChairPrice(expectedPrice: string){
        await expect(this.chairPrice.textContent()).resolves.toEqual(expectedPrice);
    }

    async verifyStock(expectedStockStatus: string){
        await expect(this.stockStatus.textContent()).resolves.toEqual(expectedStockStatus);
    }

    setSpecificChair(chairName: string){
        const chairCardContainer = this.page.locator('.product-card-container', {hasText: chairName});
        this.chairName = chairCardContainer.locator('.description').locator('div').first();
        this.chairPrice = chairCardContainer.locator('.description').locator('.price');
        this.stockStatus = chairCardContainer.locator('.status');
        this.chairImg = chairCardContainer.locator('img');
    }

    async selectChair(chairName: string){
        this.setSpecificChair(chairName);
        await this.chairImg.click();
    }

}