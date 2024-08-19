package demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends BasePage {

	@FindBy(xpath = "//span[text()='Text Box']")
	private WebElement textBoxLink;
	
	@FindBy(xpath = "//span[text()='Web Tables']")
	private WebElement webTablesLink;

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
	
	public void goToWebTablesPage() {
		webDriverWait.until(element -> {
			return webTablesLink.isDisplayed();
		});
		webTablesLink.click();
	}

}
