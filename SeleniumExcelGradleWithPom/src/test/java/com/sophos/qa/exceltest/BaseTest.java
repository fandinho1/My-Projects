package com.sophos.qa.exceltest;

import static developmentutilities.BrowserUtilities.*;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

	public WebDriver driver;
	public WebDriverWait wait;

	@Before
	public void setUp() throws Exception {
		BROWSER = CHROME_BROWSER;
		
		switch (BROWSER){
		case CHROME_BROWSER:
			System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case IE_BROWSER:
			System.setProperty("webdriver.ie.driver", "C:\\SELENIUM\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case FIREFOX_BROWSER:
			System.setProperty("webdriver.gecko.driver", "C:\\SELENIUM\\geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"logs.txt");
			driver = new FirefoxDriver();
			break;
		case EDGE_BROWSER:
			System.setProperty("webdriver.edge.driver", "C:\\SELENIUM\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			break;
		}
		
		wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);
		driver.get(URL_PAGE);
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

}
