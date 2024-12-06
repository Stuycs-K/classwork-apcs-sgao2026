public class Warrior extends Adventurer {
	// field
	private String specialName;
	private int stamina;
	private int staminaMax;
	private int speed;
	private int damage;
	
	// constructors 
	public Warrior(String name) {
		super(name);
		staminaMax = 10;
		stamina = staminaMax;
		damage = 1;
	}
	public Warrior(String name, int hp) {
		super(name, hp);
		staminaMax = 10;
		stamina = staminaMax;
		damage = 1;
	}
	
	// methods
	public String getSpecialName() {
		return "strength";
	}
	public int getSpecial() {
		return stamina;
	}
	public void setSpecial(int n) {
		stamina += n;
		if (stamina > staminaMax) stamina = staminaMax;
	}
	public int getSpecialMax() {
		return staminaMax;
	}
	
	public String attack(Adventurer other) {
		other.applyDamage(damage);
		return other.getName() + " took " + damage + " damage from " + this.getName();
	}
	
}
