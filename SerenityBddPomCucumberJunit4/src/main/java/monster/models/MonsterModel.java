package monster.models;

public class MonsterModel {
	
	private String name;
	private String hp;
	private String attack;
	private String defense;
	private String speed;
	private String monsterImg;
	public MonsterModel(String name, String hp, String attack, String defense, String speed, String monsterImg) {
		super();
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.monsterImg = monsterImg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getAttack() {
		return attack;
	}
	public void setAttack(String attack) {
		this.attack = attack;
	}
	public String getDefense() {
		return defense;
	}
	public void setDefense(String defense) {
		this.defense = defense;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getMonsterImg() {
		return monsterImg;
	}
	public void setMonsterImg(String monsterImg) {
		this.monsterImg = monsterImg;
	}
	
	

}
