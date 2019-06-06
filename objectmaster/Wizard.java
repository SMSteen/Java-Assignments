//Wizard: Set default health to 50; default intelligence to 8
//Add a method heal(Human) that heals the other human by the wizard's intelligence
//Add a method fireball(Human) that decreases the other human's health by the wizard's intelligence * 3

package com.objectmaster;

public class Wizard extends Human {
	// String c = this.getClass().getSimpleName();

	public Wizard(String name) {
		super(name);
		this.intelligence = 8;
		this.health = 50;
	}

	public void heal(Human human) {
		int healthNeeded = super.getMaxHealth(human);
		if (human == this) {
			System.out.println(String.format(
					"As lovely as it would be, %s, you cannot heal your own self. Find another %s to help you out.",
					this.playerName, this.c));
		} else if (healthNeeded <= 0) {
			System.out.println(
					String.format("%s is at full health and doesn't need any healing right now.", human.playerName));
		} else {
			if (this.intelligence > healthNeeded) {
				human.health += healthNeeded;
				System.out.println(String.format("%s has been restored to full health thanks to %s's healing powers.",
						human.playerName, this.playerName));
			} else {
				human.health += this.intelligence;
				System.out.println(String.format("%s gained %d health points thanks to %s's healing powers.",
						human.playerName, this.intelligence, this.playerName));
			}
		}
	}

	public void fireball(Human human) {
		if (human == this) {
			System.out.println(String.format(
					"Really %s? You cannot blow yourself up. Seek therapy and then hunt out other players to chuck fireballs at.",
					this.playerName));
		} else {
			int damage = this.intelligence * 3;
			if (human.health < damage) {
				human.health = 0;
				System.out.println(
						String.format("Whoa, that fireball was deadly. %s has been killed by %s's fireball attack.",
								human.playerName, this.playerName));
			} else {
				human.health -= damage;
				System.out.println(
						String.format("%s viciously attacked %s with a fireball and inflicted %d damage points.",
								this.playerName, human.playerName, damage));
			}
		}
	}
}