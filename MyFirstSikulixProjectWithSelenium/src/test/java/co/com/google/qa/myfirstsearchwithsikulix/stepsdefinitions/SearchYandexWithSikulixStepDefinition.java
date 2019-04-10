package co.com.google.qa.myfirstsearchwithsikulix.stepsdefinitions;

import static co.com.google.qa.myfirstsearchwithsikulix.pom.YandexHomePage.clickSearchBar;
import static co.com.google.qa.myfirstsearchwithsikulix.pom.YandexHomePage.writeText;
import static co.com.google.qa.myfirstsearchwithsikulix.pom.YandexHomePage.clickSearchButton;
import static co.com.google.qa.myfirstsearchwithsikulix.utils.BrowserUtilis.BROWSER;
import static co.com.google.qa.myfirstsearchwithsikulix.utils.BrowserUtilis.driver;
import static co.com.google.qa.myfirstsearchwithsikulix.utils.BrowserUtilis.URL_PAGE;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;

import co.com.google.qa.myfirstsearchwithsikulix.utils.BrowserUtilis;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchYandexWithSikulixStepDefinition {
	public static String text= "what is sikulix";
	
	@Before
	public void setUp() {
		BrowserUtilis.setDriver(BROWSER);
	}
	
	
	@Given("Lucho is on yandex home page")
	public void luchoIsOnYandexHomePage() {
		driver.get(URL_PAGE);
		driver.manage().window().maximize();		
	}

	@When("he does the search")
	public void heDoesTheSearch() throws FindFailed {
		clickSearchBar();
		writeText(text);
		clickSearchButton();
	}

	@Then("he validates successful result")
	public void heValidatesSuccessfulResult() {
		assertTrue(ExpectedConditions.elementToBeClickable(By.partialLinkText(text))!=null);
	}
	
	@After
	public void embedScreenshot(Scenario scenario) {
		try {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			driver.quit();
		} catch (RuntimeException ex) {
			System.out.println("Error in the screenshot");
		}
	}

}
