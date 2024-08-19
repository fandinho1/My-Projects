package monster.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import monster.models.MonsterModel;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("http://localhost:3000/")
public class MonsterPage extends PageObject{
	
	@FindBy(name="name")
	private WebElementFacade nameInput;
	
	@FindBy(name="hp")
	private WebElementFacade hpInput;
	
	@FindBy(name="attack")
	private WebElementFacade attackInput;
	
	@FindBy(name="defense")
	private WebElementFacade defenseInput;
	
	@FindBy(name="speed")
	private WebElementFacade speedInput;
	
	@FindBy(xpath ="//button[@data-testid='btn-create-monster']")
	private WebElementFacade createMonsterBtn;
	
	@FindBy(xpath = "//p[@data-testid='card-monster-name']")
	private WebElementFacade monsterNameCreated;
	
	@FindBy(xpath = "//span[@data-testid='card-monster-hp']")
	private WebElementFacade monsterHpCreated;
	
	@FindBy(xpath = "//span[@data-testid='card-monster-attack']")
	private WebElementFacade monsterAttackCreated;
	
	@FindBy(xpath = "//span[@data-testid='card-monster-defense']")
	private WebElementFacade monsterDefenseCreated;
	
	@FindBy(xpath = "//span[@data-testid='card-monster-speed']")
	private WebElementFacade monsterSpeedCreated;
	
	@FindBy(xpath = "//button[@data-testid='btn-delete']")
	private WebElementFacade deleteMonsterBtn;
	
	@FindBy(xpath = "//p[text()='There are no monsters']")
	private WebElementFacade noMonstersCreatedTittle;
	
	private WebElementFacade getMonsterImgToBeCreated(MonsterModel monsterModel) {
		return findBy("//section[@data-testid='monsters-list-section']//img[contains(@src,'".concat(monsterModel.getMonsterImg()).concat("')]"));		
	}
	
	private WebElementFacade getMonsterImageCreated() {
		return findBy("//div[@data-testid='monster-card']//img[@data-testid='monster-image']");
	}
	
	public void createMonster(MonsterModel monsterModel) {
		getMonsterImgToBeCreated(monsterModel).click();
		nameInput.sendKeys(monsterModel.getName());
		hpInput.sendKeys(monsterModel.getHp());
		attackInput.sendKeys(monsterModel.getAttack());
		defenseInput.sendKeys(monsterModel.getDefense());
		speedInput.sendKeys(monsterModel.getSpeed());
		createMonsterBtn.click();
	}
	
	public void verifyMonsterCreatedCorrectly(MonsterModel monsterModel) {
		assertEquals(getMonsterImgToBeCreated(monsterModel).getAttribute("src"), getMonsterImageCreated().getAttribute("src"));
		assertEquals(monsterModel.getName(), monsterNameCreated.getText());
		assertEquals(monsterModel.getAttack(), monsterAttackCreated.getAttribute("aria-valuenow"));
		assertEquals(monsterModel.getDefense(), monsterDefenseCreated.getAttribute("aria-valuenow"));
		assertEquals(monsterModel.getHp(), monsterHpCreated.getAttribute("aria-valuenow"));
		assertEquals(monsterModel.getSpeed(), monsterSpeedCreated.getAttribute("aria-valuenow"));
	}
	
	public void deleteMonsterCreated() {
		deleteMonsterBtn.click();
	}
	
	public void verifyNoMonsterCreated() {
		assertTrue(noMonstersCreatedTittle.isVisible());
	}

}
