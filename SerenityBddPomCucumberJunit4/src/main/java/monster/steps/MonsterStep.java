package monster.steps;

import monster.models.MonsterModel;
import monster.pages.MonsterPage;
import net.serenitybdd.annotations.Step;

public class MonsterStep {
	
	MonsterPage monsterPage;
	
	@Step
	public void goToMonsterPage() {
		monsterPage.open();
	}
	
	@Step
	public void createMonster(MonsterModel monsterModel) {
		monsterPage.createMonster(monsterModel);
	}
	
	@Step
	public void verifyMonsterCreatedCorrectly(MonsterModel monsterModel) {
		monsterPage.verifyMonsterCreatedCorrectly(monsterModel);
	}
	
	@Step
	public void deleteMonsterCreated() {
		monsterPage.deleteMonsterCreated();
	}
	
	@Step
	public void verifyNoMonsterCreated() {
		monsterPage.verifyNoMonsterCreated();
	}

}
