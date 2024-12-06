public class Warrior extends Adventurer {
	// field
	private int attack;
	private int support;
	private int shield;
	private int shieldMax;
	
	// constructors 
	public Warrior(String name) {
		super(name);
		shieldMax = 10;
		shield = shieldMax;
		attack = 1;
		support = 1;
	}
	public Warrior(String name, int hp) {
		super(name, hp);
		shieldMax = 10;
		shield = shieldMax;
		attack = 1;
		support = 1;
	}
	
	// methods
	public String getSpecialName() {
		return "shield";
	}
	public int getSpecial() {
		return shield;
	}
	public void setSpecial(int n) {
		shield += n;
		if (shield > shieldMax) shield = shieldMax;
	}
	public int getSpecialMax() {
		return shieldMax;
	}
	
	public String attack(Adventurer other) {
		other.applyDamage(attack);
		return other.getName() + " took " + attack + " damage from " + this.getName();
	}
	public String support(Adventurer other) {
		other.applyDamage(-1 * support);
		return this.getName() + " has increased " + other.getName() + "'s health by " + support;
	}
	public String support() {
		applyDamage(-1 * support);
		return this.getName() + " has increased their health by " + support;
	}
	public String specialAttack(Adventurer other) {
		other.applyDamage((int)(getHP() * ((shield) / 100.0)));
		shield--;
		return this.getName() + " has decreased " + other.getName() + "'s health by " + ((shield + 1) / 100.0) + "%";
	}
}
