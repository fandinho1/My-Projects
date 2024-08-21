package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends BasePage {

	@AndroidFindBy(id = "com.android.chrome:id/send_report_checkbox")
	private WebElement sendReportCheckbox;

	@AndroidFindBy(id = "com.android.chrome:id/terms_accept")
	private WebElement acceptTermsBtn;

	@AndroidFindBy(id = "com.android.chrome:id/negative_button")
	private WebElement declineSyncBtn;

	@AndroidFindBy(id = "com.android.chrome:id/search_box_text")
	private WebElement searchBar;

	public HomePage(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void uncheckSendReport() {
		sendReportCheckbox.click();
	}

	public void acceptTerms() {
		acceptTermsBtn.click();
	}

	public void declineSync() {
		declineSyncBtn.click();
	}

	public void performSearch(String wordToLook) {
		webDriverWait.until(element -> {
			return searchBar.isDisplayed();
		});
		searchBar.sendKeys(wordToLook);

		if (driver instanceof AndroidDriver) {
			((AndroidDriver) driver).longPressKey(new KeyEvent(AndroidKey.ENTER));
		} else if (driver instanceof IOSDriver) {
			searchBar.sendKeys(Keys.RETURN);
		}
	}

}
