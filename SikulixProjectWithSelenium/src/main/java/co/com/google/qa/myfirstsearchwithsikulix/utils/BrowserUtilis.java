package co.com.google.qa.myfirstsearchwithsikulix.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserUtilis {
	public static final String CHROME_BROWSER = "chrome";
	public static final String IE_BROWSER = "iexplorer";
	public static final String FIREFOX_BROWSER = "firefox";
	public static final String EDGE_BROWSER = "edge";
	
	public static String BROWSER=CHROME_BROWSER;
	
	public static final String URL_PAGE= "https://yandex.com/";
	public static final int EXPLICIT_WAIT_TIME=5;	
	public static final int IMPLICIT_WAIT_TIME=10;	
	
	public static WebDriver driver;
	public static void setDriver(String browser) {

		switch (browser) {
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
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "logs.txt");
			driver = new FirefoxDriver();
			break;
		case EDGE_BROWSER:
			System.setProperty("webdriver.edge.driver", "C:\\SELENIUM\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			break;
		}
	}

}
