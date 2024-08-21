package stepdefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hook {

	public static AppiumDriver driver;

	@Before
	public void setUp() throws IOException, URISyntaxException {
		setUpDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@After
	public void after(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png", screenshot);
		}
		driver.quit();
	}

	public static void setUpDriver() throws IOException, URISyntaxException {
		String phoneProperties = System.getProperty("deviceName", "emulator-5554");
		Properties properties = new Properties();
		String propertiesFile = getPropertiesFile(phoneProperties);

		File file = new File(propertiesFile);
		if (!file.exists()) {
			throw new IllegalArgumentException("Properties file not found for device: " + phoneProperties);
		}

		InputStream input = new FileInputStream(propertiesFile);
		properties.load(input);

		URI hubUri = new URI(properties.getProperty("hub"));

		if (properties.getProperty("platformName").equalsIgnoreCase("Android")) {
			UiAutomator2Options capabilities = new UiAutomator2Options();
			capabilities.setPlatformName(properties.getProperty("platformName"));
			capabilities.setPlatformVersion(properties.getProperty("platformVersion"));
			capabilities.setDeviceName(properties.getProperty("deviceName"));
			capabilities.setAutomationName(properties.getProperty("automationName"));
			capabilities.setAutoGrantPermissions(true);
			capabilities.setNoReset(false);
			capabilities.setAppPackage(properties.getProperty("appPackage"));
			capabilities.setAppActivity(properties.getProperty("appActivity"));
			driver = new AndroidDriver(hubUri.toURL(), capabilities);
		} else if (properties.getProperty("platformName").equalsIgnoreCase("iOS")) {
			XCUITestOptions capabilities = new XCUITestOptions();
			capabilities.setPlatformName(properties.getProperty("platformName"));
			capabilities.setPlatformVersion(properties.getProperty("platformVersion"));
			capabilities.setDeviceName(properties.getProperty("deviceName"));
			capabilities.setAutomationName(properties.getProperty("automationName"));
			capabilities.setNoReset(false);
			capabilities.setBundleId(properties.getProperty("bundleId"));
			driver = new IOSDriver(hubUri.toURL(), capabilities);
		} else {
			throw new IllegalArgumentException("Unsupported platform: " + properties.getProperty("platformName"));
		}
	}

	private static String getPropertiesFile(String deviceName) {
		return "src/test/resources/properties/".concat(deviceName.toLowerCase()).concat(".properties");
	}

}
