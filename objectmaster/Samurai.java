// Samurai: Set a default health of 200
// Add a method deathBlow(Human) that kills the other human, but reduces the Samurai's health by half
// Add a method meditate() that heals the Samurai for half of their current health.
// Add a method howMany() that returns the total current number of Samurai.

package com.objectmaster;

public class Samurai extends Human {

	public Samurai(String name) {
		super(name);
		this.health = 200;
		addSamurai();
	}

	public void deathBlow(Human human) {
		if (human == this) {
			System.out.println(String.format(
					"There's no sense in delivering a death blow to yourself! %s, you really should try meditating and seek therapy. Afterwards, you should go find other players to strike.",
					this.playerName));
		} else {
			if (this.health < 2) {
				System.out.println(String.format(
						"%s, you really don't have enough energy to lift your hand, much less deliver a death blow. Try meditating on your anger issues.",
						this.playerName));
			} else {
				human.health = 0;
				if (human.c.equals("Samurai")) {
					removeSamurai();
				}
				this.health = this.health / 2;
				System.out.println(String.format(
						"%s just delivered a deadly five finger death punch to %s. Poor %s is now dead, but %s lost %d health points in that battle.",
						this.playerName, human.playerName, human.playerName, this.playerName, this.health / 2));
			}
		}
	}

	public void meditate() {
		if (this.health >= 199) {
			System.out.println(String.format(
					"Meditation is never a bad thing, but you are at full health right now %s, so you really do not need to meditate just now",
					this.playerName));
		} else {
			int restoreAmt = this.getMaxHealth(this) / 2;
			this.health += restoreAmt;
			System.out.println(String.format(
					"%s, you really needed to meditate, didn't you? You have gained %d health points after that.",
					this.playerName, restoreAmt));
		}
	}

	public int howMany() {
		// need to figure out how to decrement when a samurai is killed
		return nSamurais;
	}
}
