package co.com.google.qa.miprimerabusqueda.stepsdefinitions;


import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import co.com.google.pom.SearchGooglePom;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchGoogleStepDefinition {
	WebDriver driver;
//By txtBuscar = By.xpath("//input[@title='Buscar']");
//By btnBuscar = By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Buscar con Google']");
	By resultadosBusqueda = By.xpath("//h1[contains(text(),'Resultados de búsqueda')]");
	String text = "cucumber java serenity";
	private SearchGooglePom searchGooglePom;

	@Given("Lucho is on google home page")
	public void lucho_is_on_google_home_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("lucho abre su navegador");
		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromedriver.exe");
		driver = new ChromeDriver();
		searchGooglePom = new SearchGooglePom(driver);
		System.out.println("lucho abre la pagina inicio google");
		driver.get("https://www.google.com.co/");
		driver.manage().window().maximize();
	}

	@When("he does the search")
	public void he_does_the_search() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("En la barra de busqueda lucho escribe una palabra");
		// driver.findElement(txtBuscar).sendKeys(text);
		searchGooglePom.escribirTextoABuscar(text);

		System.out.println("lucho da clic en el boton buscar");
		// driver.findElement(btnBuscar).submit();

		searchGooglePom.darClicEnBuscar();

	}

	@Then("he validates successful result")
	public void he_validates_successful_result() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("el actor captura los resultados de la busqueda");

		System.out.println("el actor verifica que la busqueda sea exitosa");
		assertTrue(ExpectedConditions.invisibilityOf(driver.findElement(resultadosBusqueda)) != null);
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
