package demoqa.stepdefinitions;

import static demoqa.stepdefinitions.Hook.webDriver;
import static demoqa.utils.CsvDataProvider.getAllData;
import static demoqa.utils.CsvDataProvider.getDataForRow;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demoqa.pages.ElementsPage;
import demoqa.pages.HomePage;
import demoqa.pages.TextBoxPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TextBoxStepDefinition {

	HomePage homePage = new HomePage(webDriver);
	ElementsPage elementsPage = new ElementsPage(webDriver);
	TextBoxPage textBoxPage = new TextBoxPage(webDriver);
	Map<String, String> data = new HashMap<>();
	
	@Given("the user is on demoqa home page")
	public void the_user_is_on_demoqa_home_page() {
		homePage.goToDemoQaPage();
	}

	@When("he go to text box inside of elements option")
	public void he_go_to_text_box_inside_of_elements_option() {
		homePage.goToElementsPage();
		elementsPage.goToTextBoxPage();
	}

	@When("he submit the text box form with all fields of specific row from csv {string} {int}")
	public void he_submit_the_text_box_form_with_all_fields_one_row(String csvName, int row) throws IOException {
		data = getDataForRow(csvName,row);
		textBoxPage.fillFullNameField(data.get("Name"));
		textBoxPage.fillEmailField(data.get("Email"));
		textBoxPage.fillCurrentAddressField(data.get("CurrentAddress"));
		textBoxPage.fillPermanentAddressField(data.get("PermanentAddress"));
		textBoxPage.submitTheForm();
	}

	@Then("he should see the form was submitted correctly")
	public void he_should_see_the_form_was_submitted_correctly() {
		textBoxPage.verifyFormSent(data.get("Name"), data.get("Email"), data.get("CurrentAddress"), data.get("PermanentAddress"));
	}
	
	@When("he submit the text box form with all fields of all rows from csv {string}")
	public void he_submit_the_text_box_form_with_all_fields_all_rows(String csvName) throws IOException {
		List<Map<String, String>> allData = getAllData(csvName);
		
		for (Map<String, String> record : allData) {
			System.out.println("the name is: "+ record.get("Name"));
			System.out.println("the name is: "+ record.get("Email"));
			System.out.println("the name is: "+ record.get("CurrentAddress"));
			System.out.println("the name is: "+ record.get("PermanentAddress"));
        }
		
	}

}
