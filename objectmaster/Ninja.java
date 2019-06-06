// Ninja: Set default stealth to 10
// Ninja: Add a method steal(Human) that takes the amount of stealth the ninja has, removes it from the other human's health, and adds it to the ninja's
// Ninja: Add a method runAway() that decreases their health by 10

package com.objectmaster;

public class Ninja extends Human {

	public Ninja(String name) {
		super(name);
		this.stealth = 10;
	}

	public void steal(Human human) {
		int healthNeeded = super.getMaxHealth(this);
		System.out.println("health needed " + healthNeeded);
		if (human == this) {
			System.out.println(String.format(
					"Nice try %s, but you cannot steal your own health silly! Creep up on another player and steal their health, you thief.",
					this.playerName));
		} else if (healthNeeded <= 0) {
			System.out.println(String.format(
					"Your are at full health right now %s. No need to steal from others, you thief.", this.playerName));
		} else {
			if (human.health < this.stealth) {
				human.health = 0;
				System.out.println(String.format("That sneaky ninja, %s, stole what life %s had left. %s is now dead.",
						this.playerName, human.playerName, human.playerName));
			} else {
				if (this.stealth > healthNeeded) {
					this.health += healthNeeded;
					human.health -= this.stealth;
					System.out.println(String.format(
							"%s, an honest thief for once, stole only what was needed to be restored back to full health... %d health points were stolen from %s.",
							this.playerName, healthNeeded, human.playerName));
				} else {
					this.health += this.stealth;
					human.health -= this.stealth;
					System.out.println(
							String.format("%s, the sneaky ninja thief, snuck up on %s and stole %d health points.",
									this.playerName, human.playerName, this.stealth));
				}
			}
		}
	}

	public void runAway() {
		if (this.health <= 10) {
			this.health = 0;
			System.out.println(String.format(
					"Unfortunately %s, you successfully ran away from an attack but you've completely depleted your energy and have died.",
					this.playerName));
		} else {
			this.health -= 10;
			System.out.println(String.format("%s ran away from the fight and lost 10 health points.", this.playerName));
		}
	}
}
