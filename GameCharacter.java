abstract class GameCharacter {
	
	String name; // Character's name
	private int hp; // Health points

	public GameCharacter(String name) {
		this.name = name;
	}

	// Get current HP
	public int getHP() {
		return hp;
	}

	// Set HP (used to initialize HP)
	public void setHP(int hp) {
		this.hp = hp;
	}

	public void takeDamage(int damage) {
		this.hp -= damage;
		if (this.hp < 0)
			this.hp = 0;
	}

	// Attack move, returns the damage
	public int attack(Random rand) {
		return getAttackDamage(rand);
	}

	// Special move, returns the damage
	public int specialMove(Random rand) {
		return getSpecialMoveDamage(rand);
	}

	// Helper method to calculate attack damage
	protected int getAttackDamage(Random rand) {
		return rand.nextInt(21) + 10; // 10–30 damage
	}

	// Helper method to calculate special move damage
	protected int getSpecialMoveDamage(Random rand) {
		return rand.nextInt(21) + 20; // 20–40 damage
	}

	public abstract String getAttackName();
	public abstract String getSpecialMoveName();
}
