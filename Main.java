public class Main {

	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null, "Welcome to Arcane Duels!");

		String mageName = JOptionPane.showInputDialog("Enter Mage's Name:");
		String warriorName = JOptionPane.showInputDialog("Enter Warrior's Name:");

		// Mage and Warrior instances
		GameCharacter mage = new Mage(mageName);
		GameCharacter warrior = new Warrior(warriorName);

		// Initialize 100 HP
		mage.setHP(100);
		warrior.setHP(100);

		JOptionPane.showMessageDialog(null, "Game starts!\nBoth characters have 100 HP.");

		Random rand = new Random(); // Random object for damage calculation
		int round = 1; // Round counter

		while (true) {

			// Mage's Turn
			int mageChoice = JOptionPane.showOptionDialog(null, "Round " + round + "\nChoose " + mageName + "’s move:",
					"Mage Turn", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
					new String[] { "Attack", "Special Move" }, null);

			int mageDamage = 0;

			if (mageChoice == 0) {
				mageDamage = mage.attack(rand);
				JOptionPane.showMessageDialog(null,
						mageName + " " + mage.getAttackName() + "  (" + mageDamage + " damage)");
			} else if (mageChoice == 1) {
				mageDamage = mage.specialMove(rand);
				JOptionPane.showMessageDialog(null,
						mageName + " " + mage.getSpecialMoveName() + "  (" + mageDamage + " damage)");
			} else {
				JOptionPane.showMessageDialog(null, "Game cancelled or window closed.");
				return;
			}

			// Apply damage to Warrior, get current HP
			warrior.takeDamage(mageDamage);
			int warriorHP = Math.max(warrior.getHP(), 0);

			// Check if Warrior is defeated
			if (warriorHP == 0) {
				showFinalHP(mageName, mage.getHP(), warriorName, warriorHP);
				JOptionPane.showMessageDialog(null, mageName + " wins the Arcane Duels! 🏆");
				break;
			}

			// Warrior's Turn
			int warriorChoice = JOptionPane.showOptionDialog(null,
					"Round " + round + "\nChoose " + warriorName + "’s move:", "Warrior Turn",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
					new String[] { "Attack", "Special Move" }, null);

			int warriorDamage = 0;

			if (warriorChoice == 0) {
				warriorDamage = warrior.attack(rand);
				JOptionPane.showMessageDialog(null,
						warriorName + " " + warrior.getAttackName() + "  (" + warriorDamage + " damage)");
			} else if (warriorChoice == 1) {
				warriorDamage = warrior.specialMove(rand);
				JOptionPane.showMessageDialog(null,
						warriorName + " " + warrior.getSpecialMoveName() + "  (" + warriorDamage + " damage)");
			} else {
				JOptionPane.showMessageDialog(null, "Game cancelled or window closed.");
				return;
			}

			// Apply damage to Mage, get current HP
			mage.takeDamage(warriorDamage);
			int mageHP = Math.max(mage.getHP(), 0);

			// Check if Mage is defeated
			if (mageHP == 0) {
				showFinalHP(mageName, mageHP, warriorName, warrior.getHP());
				JOptionPane.showMessageDialog(null, warriorName + " wins the Arcane Duels! 🏆");
				break; 
			}

			// Current HP status
			JOptionPane.showMessageDialog(null, "HP Status:\n" + mageName + " (Mage): " + mageHP + " HP\n" + warriorName
					+ " (Warrior): " + warriorHP + " HP");

			round++; // Increment round
		}

		JOptionPane.showMessageDialog(null, "Game over. Thanks for playing!");
	}

	// Final HP status
	private static void showFinalHP(String mageName, int mageHP, String warriorName, int warriorHP) {
		JOptionPane.showMessageDialog(null, "HP Status:\n" + mageName + " (Mage): " + mageHP + " HP\n" + warriorName
				+ " (Warrior): " + warriorHP + " HP");
	}
}
