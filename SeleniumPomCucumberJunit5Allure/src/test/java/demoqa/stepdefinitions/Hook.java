package demoqa.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hook {
	
	public static WebDriver webDriver;

	@Before
	public void setUp() {
		String browser = System.getProperty("browser", "chrome");
		
		switch (browser) {
		case "chrome": 
			webDriver = new ChromeDriver();
			break;	
		case "edge": 
			webDriver = new EdgeDriver();
			break;
		case "firefox": 
			webDriver = new FirefoxDriver();
			break;		
		default:
			throw new IllegalArgumentException("Browser not supported: " + browser);
		}
		
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
	}
	
	@After
	public void after(Scenario scenario) {
		if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png", screenshot);
        }
		webDriver.quit();
	}
}
