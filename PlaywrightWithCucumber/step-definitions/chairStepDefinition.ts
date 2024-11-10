import { Given, When, Then } from '@cucumber/cucumber'

Given('the user is on chairs page', async function () {
  await this.pageManager.onHomePage().navigateToChairsPage();
});

When('he see the chair {string}', async function (chairToLookFor) {
  this.pageManager.onChairPage().setSpecificChair(chairToLookFor);
  await this.pageManager.onChairPage().verifyChairName(chairToLookFor);
});

Then('he should see the status {string}', async function (expectedStatus) {
  await this.pageManager.onChairPage().verifyStock(expectedStatus);
});