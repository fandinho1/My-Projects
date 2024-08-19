package demoqa.stepdefinitions;

import static demoqa.utils.JsonDataProvider.readJsonFile;
import static demoqa.stepdefinitions.Hook.webDriver;

import java.util.HashMap;
import java.util.Map;

import demoqa.pages.ElementsPage;
import demoqa.pages.HomePage;
import demoqa.pages.WebTablePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebTableStepDefinition {
	
	HomePage homePage = new HomePage(webDriver);
	ElementsPage elementsPage = new ElementsPage(webDriver);
	WebTablePage webTablePage = new WebTablePage(webDriver);
	Map<String, Object> dataFromJson = new HashMap<String, Object>();

	@When("he go to web table option")
	public void he_go_to_web_table_option() {
		homePage.goToElementsPage();
		elementsPage.goToWebTablesPage();
	}

	@When("he add a new row in the table using data from json file {string}")
	public void he_add_a_new_row_in_the_table_using_data_from_json_file(String jsonFileName) {
		dataFromJson=readJsonFile(jsonFileName);
		webTablePage.addNewRow();
		webTablePage.fillFirstName(dataFromJson.get("firstName").toString());
		webTablePage.fillLastName(dataFromJson.get("lastName").toString());
		webTablePage.fillAge(dataFromJson.get("age").toString());
		webTablePage.fillEmail(dataFromJson.get("email").toString());
		webTablePage.fillSalary(dataFromJson.get("salary").toString());
		webTablePage.fillDepartment(dataFromJson.get("department").toString());
		webTablePage.sendForm();
	}

	@Then("he should see a new row in the table with the correct data")
	public void he_should_see_a_new_row_in_the_table_with_the_correct_data() {
		
	}

}
