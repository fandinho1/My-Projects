package demoqa.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage extends BasePage {

	@FindBy(id = "firstName")
	private WebElement firstNameInput;

	@FindBy(id = "lastName")
	private WebElement lastNameInput;

	@FindBy(id = "userEmail")
	private WebElement emailInput;

	@FindBy(id = "userNumber")
	private WebElement mobileInput;

	@FindBy(id = "dateOfBirthInput")
	private WebElement dateOfBirthInput;

	@FindBy(className = "react-datepicker__year-select")
	private WebElement yearSelect;

	@FindBy(className = "react-datepicker__month-select")
	private WebElement monthSelect;

	@FindBy(id = "subjectsContainer")
	private WebElement subjectInput;

	@FindBy(id = "uploadPicture")
	private WebElement selectFileInput;

	@FindBy(id = "currentAddress")
	private WebElement currentAddressTextArea;

	@FindBy(id = "state")
	private WebElement stateSelect;

	@FindBy(id = "city")
	private WebElement citySelect;
	
	@FindBy(id="submit")
	private WebElement submitBtn;

	@FindBy(xpath = "//td[text()='Student Name']/following-sibling::td")
	private WebElement fullNameSubmitted;

	@FindBy(xpath = "//td[text()='Student Email']/following-sibling::td")
	private WebElement emailSubmitted;

	@FindBy(xpath = "//td[text()='Gender']/following-sibling::td")
	private WebElement genderSubmitted;

	@FindBy(xpath = "//td[text()='Mobile']/following-sibling::td")
	private WebElement mobileSubmitted;

	@FindBy(xpath = "//td[text()='Date of Birth']/following-sibling::td")
	private WebElement dateOfBirthSubmitted;

	@FindBy(xpath = "//td[text()='Subjects']/following-sibling::td")
	private WebElement subjectsSubmitted;

	@FindBy(xpath = "//td[text()='Hobbies']/following-sibling::td")
	private WebElement hobbiesSubmitted;

	@FindBy(xpath = "//td[text()='Picture']/following-sibling::td")
	private WebElement pictureSubmitted;

	@FindBy(xpath = "//td[text()='Address']/following-sibling::td")
	private WebElement addressSubmitted;

	@FindBy(xpath = "//td[text()='State and City']/following-sibling::td")
	private WebElement stateAndCitySubmitted;

	private Calendar dateOfBirth;
	private String[] subjectsArray;
	private String[] hobbiesArray;

	public PracticeFormPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	private WebElement getGenderOption(String gender) {
		String genderXpath = String.format("//input[@name='gender'][@value='%s']/following-sibling::label", gender);
		return webDriver.findElement(By.xpath(genderXpath));
	}

	private WebElement getHobbieCheckBox(String hobbie) {
		String hobbieXpath = String.format("//label[text()='%s']", hobbie);
		return webDriver.findElement(By.xpath(hobbieXpath));
	}

	public void fillFirstName(String firstName) {
		webDriverWait.until(element -> {
			return firstNameInput.isDisplayed();
		});
		firstNameInput.sendKeys(firstName);
	}

	public void fillLastName(String lastName) {
		lastNameInput.sendKeys(lastName);
	}

	public void fillEmail(String email) {
		emailInput.sendKeys(email);
	}

	public void selectGenderOption(String gender) {
		getGenderOption(gender).click();
	}

	public void fillMobile(String mobile) {
		mobileInput.sendKeys(mobile);
	}

	public void fillDateOfBirth(String dateOfBirth) {
		dateOfBirthInput.clear();
		setDateOfBirth(dateOfBirth);

		Select year = new Select(yearSelect);
		Select month = new Select(monthSelect);
		year.selectByValue("" + this.dateOfBirth.get(Calendar.YEAR));
		month.selectByValue("" + this.dateOfBirth.get(Calendar.MONTH));
		String dayXpath = String.format("//div[contains(@class,'react-datepicker__day') and text()='%s']",
				this.dateOfBirth.get(Calendar.DAY_OF_MONTH));
		webDriver.findElement(By.xpath(dayXpath)).click();
	}

	private void setDateOfBirth(String dateOfBirth) {
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		this.dateOfBirth = Calendar.getInstance();
		try {
			Date date = format.parse(dateOfBirth);
			this.dateOfBirth.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void fillSubject(String subjects) {
		this.subjectsArray = subjects.split(",");
		Actions actions = new Actions(webDriver);
		actions.moveToElement(subjectInput).click().perform();
		for (String subject : this.subjectsArray) {
			actions.sendKeys(subject).perform();
			WebElement autoCompleteMenu = webDriver
					.findElement(By.xpath("//div[contains(@class,'subjects-auto-complete__menu')]"));
			webDriverWait.until(element -> {
				return autoCompleteMenu.isDisplayed();
			});
			actions.sendKeys(Keys.TAB).perform();
		}
	}

	public void selectHobbies(String hobbies) {
		this.hobbiesArray = hobbies.split(",");

		for (String hobby : this.hobbiesArray) {
			getHobbieCheckBox(hobby).click();
		}
	}

	public void selectFile(String imageName) {
		String pathImage = String.format(System.getProperty("user.dir").concat("/src/test/resources/data/%s"),
				imageName);
		selectFileInput.sendKeys(pathImage);
	}

	public void fillCurrentAddress(String currentAddress) {
		currentAddressTextArea.sendKeys(currentAddress);
	}

	public void selectState(String stateName) {
		stateSelect.click();
		String stateXpath = String.format("//div[contains(text(),'%s')]", stateName);
		webDriver.findElement(By.xpath(stateXpath)).click();
	}

	public void selectCity(String cityName) {
		citySelect.click();
		String stateXpath = String.format("//div[contains(text(),'%s')]", cityName);
		webDriver.findElement(By.xpath(stateXpath)).click();
	}
	
	public void sendForm() {
		submitBtn.click();
	}

	public void verifyPersonalInfo(String firstName, String lastName, String email, String gender, String mobile,
			String address) {
		assertEquals(firstName.concat(" ").concat(lastName), fullNameSubmitted.getText(),
				"Actual name is not the same as the sent name");
		assertEquals(email, emailSubmitted.getText(), "Actual email is not the same as the sent email");
		assertEquals(gender, genderSubmitted.getText(), "Actual gender is not the same as the sent gender");
		assertEquals(mobile, mobileSubmitted.getText(), "Actual mobile is not the same as the sent mobile");
		assertEquals(address, addressSubmitted.getText(), "Actual address is not the same as the sent address");
	}

	public void verifyDateOfBirth() {
		assertTrue(dateOfBirthSubmitted.getText().contains("" + this.dateOfBirth.get(Calendar.YEAR)));
		assertTrue(dateOfBirthSubmitted.getText()
				.contains(this.dateOfBirth.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH)));
		assertTrue(dateOfBirthSubmitted.getText().contains(this.dateOfBirth.get(Calendar.DAY_OF_MONTH) + " "));
	}

	public void verifySubjects() {
		for (String subject : this.subjectsArray) {
			assertTrue(subjectsSubmitted.getText().contains(subject),
					"The subject " + subject + " is not present in the form submitted");
		}
	}

	public void verifyHobbies() {
		for (String hobby : this.hobbiesArray) {
			assertTrue(hobbiesSubmitted.getText().contains(hobby),
					"The Hobby " + hobby + " is not present in the form submitted");
		}
	}

	public void verifyPicture(String imageName) {
		assertEquals(imageName, pictureSubmitted.getText(), "Actual picture file is not the same as the sent picture");
	}

	public void verifyStateAndCity(String state, String city) {
		assertEquals(state.concat(" ").concat(city), stateAndCitySubmitted.getText(),
				"Actual state and city are not the same as the sent state and city");
	}

}
