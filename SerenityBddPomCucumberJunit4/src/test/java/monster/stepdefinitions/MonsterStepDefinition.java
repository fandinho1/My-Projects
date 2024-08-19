package monster.stepdefinitions;

import java.util.List;
import java.util.Map;

import io.cucumber.java.After;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import monster.models.MonsterModel;
import monster.steps.MonsterStep;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

public class MonsterStepDefinition {
	
	@Steps
	MonsterStep monsterStep;
	
	@DataTableType
	public MonsterModel incomeEntry(Map<String, String> entries) {
		return new MonsterModel(entries.get("name"), entries.get("hp"), entries.get("attack"), entries.get("defense"), entries.get("speed"), entries.get("monsterImg"));
	}
	
	@Given("the user is on monster page")
	public void theUserIsOnMonsterPage() {
		monsterStep.goToMonsterPage();
	}
	
	@When("he creates a monster")
	public void heCreatesAMonster(List<MonsterModel> monsterModels) {
		monsterStep.createMonster(monsterModels.get(0));
	}
	
	@Then("he should see the monster created correctly")
	public void heShouldSeeTheMonsterCreatedCorrectly(List<MonsterModel> monsterModels) {
		monsterStep.verifyMonsterCreatedCorrectly(monsterModels.get(0));
	}
	

	@When("he delete the monster created")
	public void heDeleteTheMonsterCreated() {
		monsterStep.deleteMonsterCreated();
	}
	
	@Then("he should not see monsters in his space")
	public void heShouldNotSeeMonstersInHisSpace() {
		monsterStep.verifyNoMonsterCreated();
	}





	@After
	public void after() {
		Serenity.getDriver().close();
		Serenity.getDriver().quit();
	}


}
