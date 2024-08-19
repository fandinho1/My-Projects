package demoqa.stepdefinitions;

import static demoqa.stepdefinitions.Hook.webDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demoqa.pages.FormsPage;
import demoqa.pages.HomePage;
import demoqa.pages.PracticeFormPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PracticeFormStepDefinition {

	HomePage homePage = new HomePage(webDriver);
	FormsPage formsPage = new FormsPage(webDriver);
	PracticeFormPage practiceFormPage = new PracticeFormPage(webDriver);
	Map<String, String> formData = new HashMap<String, String>();

	@When("he go to forms option")
	public void he_go_to_forms_option() {
		homePage.goToFormsPage();
		formsPage.goToPracticeForm();
	}

	@When("he submit the practice form with all fields")
	public void he_submit_the_practice_form_with_all_fields(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		formData = data.get(0);
		practiceFormPage.fillFirstName(formData.get("firstName"));
		practiceFormPage.fillLastName(formData.get("lastName"));
		practiceFormPage.fillEmail(formData.get("email"));
		practiceFormPage.selectGenderOption(formData.get("gender"));
		practiceFormPage.fillMobile(formData.get("mobile"));
		practiceFormPage.fillDateOfBirth(formData.get("dateOfBirth"));
		practiceFormPage.fillSubject(formData.get("subjects"));
		practiceFormPage.selectHobbies(formData.get("hobbies"));
		practiceFormPage.selectFile(formData.get("picture"));
		practiceFormPage.fillCurrentAddress(formData.get("currentAddress"));
		practiceFormPage.selectState(formData.get("state"));
		practiceFormPage.selectCity(formData.get("city"));
		practiceFormPage.sendForm();
	}

	@Then("he should see the practice form was submitted correctly")
	public void he_should_see_the_practice_form_was_submitted_correctly() {
		practiceFormPage.verifyPersonalInfo(formData.get("firstName"), formData.get("lastName"), formData.get("email"),
				formData.get("gender"), formData.get("mobile"), formData.get("currentAddress"));
		practiceFormPage.verifyPicture(formData.get("picture"));
		practiceFormPage.verifyDateOfBirth();
		practiceFormPage.verifySubjects();
		practiceFormPage.verifyHobbies();
		practiceFormPage.verifyStateAndCity(formData.get("state"), formData.get("city"));
	}

}
