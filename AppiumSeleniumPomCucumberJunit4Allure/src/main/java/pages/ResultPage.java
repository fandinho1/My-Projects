package pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;

public class ResultPage extends BasePage{

	public ResultPage(AppiumDriver driver) {
		super(driver);
	}
	
	private String getXpathExpectedResult(String expectedResult) {
		return String.format("//android.view.View[@content-desc='%s']", expectedResult);
	}
	
	public void verifySearchShowExpectedResult(String expectedResult) {
		assertTrue(!driver.findElements(By.xpath(getXpathExpectedResult(expectedResult))).isEmpty());
	}

}
