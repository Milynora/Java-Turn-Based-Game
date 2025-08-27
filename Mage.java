class Mage extends GameCharacter {
	public Mage(String name) {
		super(name);
	}

	@Override
	public String getAttackName() {
		return "casts Fireball!";
	}

	@Override
	public String getSpecialMoveName() {
		return "uses Lightning Storm!";
	}
}
