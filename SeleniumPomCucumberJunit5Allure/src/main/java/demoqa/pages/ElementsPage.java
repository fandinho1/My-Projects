package demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends BasePage {

	@FindBy(xpath = "//span[text()='Text Box']")
	private WebElement textBoxLink;

	public ElementsPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	public void goToTextBoxPage() {
		webDriverWait.until(element -> {
			return textBoxLink.isDisplayed();
		});
		textBoxLink.click();
	}

}
