import {Locator, Page} from '@playwright/test';

export class HomePage{

    readonly page: Page;
    readonly chairsLink: Locator;
    readonly cartLink: Locator;

    constructor(page: Page){
        this.page=page;
        this.chairsLink=page.locator('.chairs');
        this.cartLink = page.locator('.cart');
    }

    async navigateToChairsPage(){
        await this.chairsLink.waitFor({state:'visible'});
        await this.chairsLink.click();
    }
    
    async navigateToCartPage(){
        await this.cartLink.waitFor({state:'visible'});
        await this.cartLink.click();
    }
}