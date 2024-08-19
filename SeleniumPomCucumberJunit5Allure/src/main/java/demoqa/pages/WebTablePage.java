package demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage extends BasePage {
	
	@FindBy(id="addNewRecordButton")
	private WebElement addBtn;
	
	@FindBy(id="firstName")
	private WebElement firstNameInput;
	
	@FindBy(id="lastName")
	private WebElement lastNameInput;
	
	@FindBy(id="userEmail")
	private WebElement emailInput;
	
	@FindBy(id="age")
	private WebElement ageInput;
	
	@FindBy(id="salary")
	private WebElement salaryInput;
	
	@FindBy(id="department")
	private WebElement departmentInput;
	
	@FindBy(id="submit")
	private WebElement submitBtn;
	
	public WebTablePage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	public void addNewRow() {
		addBtn.click();
	}
	
	public void fillFirstName(String firstName) {
		firstNameInput.sendKeys(firstName);
	}
	
	public void fillLastName(String lastName) {
		lastNameInput.sendKeys(lastName);
	}
	
	public void fillEmail(String email) {
		emailInput.sendKeys(email);
	}
	
	public void fillAge(String age) {
		ageInput.sendKeys(age);
	}
	
	public void fillSalary(String salary) {
		salaryInput.sendKeys(salary);
	}
	
	public void fillDepartment(String department) {
		departmentInput.sendKeys(department);
	}
	
	public void sendForm() {
		submitBtn.click();
	}

}
