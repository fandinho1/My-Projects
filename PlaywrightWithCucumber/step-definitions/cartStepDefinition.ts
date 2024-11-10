import { Given, When, Then } from "@cucumber/cucumber";
import { pageFixture } from "../hooks/pageFixture";

When('he add the chair {string} to the cart', async function (chair: string) {
  this.selectedChair = chair;
  await this.pageManager.onChairPage().selectChair(chair);
  await this.pageManager.onProductDetailsPage().addProductToCart();
});

Then('he should see the selected chair in the cart', async function () {
  await this.pageManager.onHomePage().navigateToCartPage();
  this.pageManager.onCartPage().setProduct(this.selectedChair);
  await this.pageManager.onCartPage().verifyProductInCart(this.selectedChair);
});

When('he add the followings chairs to the cart', async function (chairsData) {
  const chairs = chairsData.rawTable.map(row => row[0]);
  this.selectedChairs= chairs;
  for (const chair of chairs) {
    await this.pageManager.onChairPage().selectChair(chair);
    await this.pageManager.onProductDetailsPage().addProductToCart();
    await pageFixture.page.goBack();
  }
  await this.pageManager.onHomePage().navigateToCartPage();
});

Then('he should see all the selected chairs in the cart', async function () {
  
  await this.pageManager.onCartPage().verifyProductsInCart(this.selectedChairs);
});