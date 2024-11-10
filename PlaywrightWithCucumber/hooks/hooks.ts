import { After, Before, Status, BeforeAll, AfterAll } from "@cucumber/cucumber";
import { Browser, Page, BrowserContext } from "@playwright/test";
import { pageFixture } from "./pageFixture";
import { launchBrowser } from "./browserSetup";
import { setDefaultTimeout } from "@cucumber/cucumber";
import { PageManager } from "../page-objects/pageManager";

setDefaultTimeout(60000);
let browser: Browser;
let page: Page;
let context: BrowserContext;
let browserName;

BeforeAll(async function () {
    browserName = process.env.BROWSER;
    browser = await launchBrowser(browserName);
})

Before(async function () {
    context = await browser.newContext({bypassCSP:true,ignoreHTTPSErrors: true});
    page = await browser.newPage();
    pageFixture.page = page;
    await pageFixture.page.goto('https://shopist.io/');
    this.pageManager = new PageManager(pageFixture.page)
})

After(async function ({pickle, result}) {
    if(result.status == Status.FAILED){
        const image = await pageFixture.page.screenshot({path: `./test-result/screenshots/${browserName}-${pickle.name}.png`, type:"png"});
        await this.attach(image,"image/png");
    }
    await page.close();
    await context.close();
})

AfterAll(async function () {
    //await new Promise(resolve => setTimeout(resolve, 3000));  // Espera activa adicional (3 segundos)
    await browser.close();
});
