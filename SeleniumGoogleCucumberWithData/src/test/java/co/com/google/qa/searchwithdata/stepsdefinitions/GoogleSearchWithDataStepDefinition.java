package co.com.google.qa.searchwithdata.stepsdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import co.com.google.pom.SearchGoogleWithDataPom;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchWithDataStepDefinition {
	WebDriver driver;
	By resultadosBusqueda = By.xpath("//h1[contains(text(),'Resultados de búsqueda')]");
	String text = "cucumber java serenity";
	private SearchGoogleWithDataPom searchGoogleWithDataPom;

	@Given("He is in the site google")
	public void heIsInTheSiteGoogle() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("lucho abre su navegador");
		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromedriver.exe");
		driver = new ChromeDriver();
		searchGoogleWithDataPom = new SearchGoogleWithDataPom(driver);
		System.out.println("El abre la pagina inicio google");
		driver.get("https://www.google.com.co/");
		driver.manage().window().maximize();
	}

	@When("He search the word {string}")
	public void heSearchTheWord(String word) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("El busca la palabra " + word);
		searchGoogleWithDataPom.escribirTextoABuscar(word);
		
		searchGoogleWithDataPom.darClicEnBuscar();

	}

	@Then("He verify that the word {string} is in the results")
	public void heVerifyThatTheWordIsInTheResults(String word) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("El encuentra la palabra " + word);
		driver.quit();

	}
	
	@After
	public void embedScreenshot(Scenario scenario) {
		try {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			driver.quit();
		} catch (RuntimeException ex) {
			System.out.println("Error en la captura");

		}
	}
}
