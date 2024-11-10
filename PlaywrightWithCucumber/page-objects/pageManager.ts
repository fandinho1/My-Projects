import { Page } from "@playwright/test";
import { HomePage } from "./homePage";
import { ChairPage } from "./chairPage";
import { ProductDetailsPage } from "./productDetailsPage";
import { CartPage } from "./cartPage";

export class PageManager{

    private readonly page: Page;
    private readonly homePage: HomePage;
    private readonly chairPage: ChairPage;
    private readonly productDetailsPage: ProductDetailsPage;
    private readonly cartPage: CartPage;

    constructor(page: Page){
        this.page=page;
        this.homePage = new HomePage(page);
        this.chairPage = new ChairPage(page);
        this.productDetailsPage= new ProductDetailsPage(page);
        this.cartPage = new CartPage(page);
    }

    onHomePage(){
        return this.homePage;
    }

    onChairPage(){
        return this.chairPage;
    }

    onProductDetailsPage(){
        return this.productDetailsPage;
    }

    onCartPage(){
        return this.cartPage;
    }

}