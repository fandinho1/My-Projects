package demoqa.pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BasePage {

	@FindBy(id = "userName")
	private WebElement fullNameInput;

	@FindBy(id = "userEmail")
	private WebElement emailInput;

	@FindBy(id = "currentAddress")
	private WebElement currentAddressInput;

	@FindBy(id = "permanentAddress")
	private WebElement permanentAddressInput;

	@FindBy(id = "submit")
	private WebElement submitBtn;

	@FindBy(xpath = "//div[@id='output']//p[@id='name']")
	private WebElement nameTxt;

	@FindBy(xpath = "//div[@id='output']//p[@id='email']")
	private WebElement emailTxt;

	@FindBy(xpath = "//div[@id='output']//p[@id='currentAddress']")
	private WebElement currentAddressTxt;

	@FindBy(xpath = "//div[@id='output']//p[@id='permanentAddress']")
	private WebElement permanentAddressTxt;

	public TextBoxPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	public void fillFullNameField(String name) {
		fullNameInput.clear();
		fullNameInput.sendKeys(name);
	}

	public void fillEmailField(String email) {
		emailInput.clear();
		emailInput.sendKeys(email);
	}

	public void fillCurrentAddressField(String currentAddress) {
		currentAddressInput.clear();
		currentAddressInput.sendKeys(currentAddress);
	}

	public void fillPermanentAddressField(String permanentAddress) {
		permanentAddressInput.clear();
		permanentAddressInput.sendKeys(permanentAddress);
	}

	public void submitTheForm() {
		submitBtn.click();
	}

	public void verifyFormSent(String name, String email, String currentAddress, String permanentAddress) {
		webDriverWait.until(element -> {
			return nameTxt.isDisplayed();
		});
		assertTrue(nameTxt.getText().contains(name));
		assertTrue(emailTxt.getText().contains(email));
		assertTrue(currentAddressTxt.getText().contains(currentAddress));
		assertTrue(permanentAddressTxt.getText().contains(permanentAddress));
	}

}
