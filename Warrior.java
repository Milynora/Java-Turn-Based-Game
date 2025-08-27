class Warrior extends GameCharacter {
	public Warrior(String name) {
		super(name);
	}

	@Override
	public String getAttackName() {
		return "slashes with his sword!";
	}

	@Override
	public String getSpecialMoveName() {
		return "uses Shield Bash!";
	}
}
