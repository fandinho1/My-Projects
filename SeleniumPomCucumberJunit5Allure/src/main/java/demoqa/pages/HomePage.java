package demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	
	private static final String HOME_URL="https://demoqa.com/";
	
	@FindBy(xpath = "//h5[text()='Elements']")
	private WebElement elementsLink;
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void goToDemoQaPage() {
		webDriver.get(HOME_URL);
	}
	
	public void goToElementsPage() {
		elementsLink.click();
	}

}
