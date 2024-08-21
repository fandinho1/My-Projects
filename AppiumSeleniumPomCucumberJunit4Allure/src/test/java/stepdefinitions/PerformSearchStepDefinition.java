package stepdefinitions;

import pages.HomePage;
import pages.ResultPage;

import static stepdefinitions.Hook.driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PerformSearchStepDefinition {
	
	HomePage homePage = new HomePage(driver);
	ResultPage resultPage = new ResultPage(driver);
	
	@Given("the user is in the Chrome search bar")
	public void theUserIsInTheChromeSearchBar() {
		homePage.uncheckSendReport();
		homePage.acceptTerms();
		homePage.declineSync();
	}
	
	@When("he performs a search by typing {string}")
	public void hePerformsASearchByTyping(String wordToLook) {
		homePage.performSearch(wordToLook);
	}
	
	@Then("he should see {string} result")
	public void heShouldSeeResultsForHisSearch(String expectedResult) {
		resultPage.verifySearchShowExpectedResult(expectedResult);
	}

}
