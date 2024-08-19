package demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPage extends BasePage {

	@FindBy(xpath = "//span[text()='Practice Form']")
	private WebElement practiceFormLink;

	public FormsPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	public void goToPracticeForm() {
		webDriverWait.until(element -> {
			return practiceFormLink.isDisplayed();
		});
		practiceFormLink.click();
	}

}
