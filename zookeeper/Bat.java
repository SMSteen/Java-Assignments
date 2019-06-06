//Create a Bat class that has a default energy level of 300 and

//can fly() - print the sound a bat taking off and decrease its energy by 50

//eatHumans() - print the so- well, never mind, just increase its energy by 25

//attackTown() - print the sound of a town on fire and decrease its energy by 100

package com.pollydesigns.zookeeper;

public class Bat extends Mammal {
	String c = this.getClass().getSimpleName();
	
	public Bat() {
		this.energyLevel = 300;
	}
	
	public void fly() {
		if (this.energyLevel < 50) {
			System.out.println(String.format("The %s is too tired to fly and should eat more humans to gain some energy.", this.c));
		} else {			
			this.energyLevel -= 50;
			System.out.println(String.format("Flip flap flutter swish swoosh. The %s is flying and has lowered its energy to %d.", this.c, this.energyLevel));
		}
	}

	public void eatHuman() {
		this.energyLevel += 25;
		System.out.println(String.format("Chomp crunch burp. That human was tasty; send more! The %s has eaten a human and its energy increased to %d.", this.c, this.energyLevel));
	}
	
	public void attackTown() {
		if (this.energyLevel < 100) {
			System.out.println(String.format("The %s is way too tired to attack a town and would only face defeat. It should eat more humans to gain some energy.", this.c));
		} else {			
			this.energyLevel -= 100;
			System.out.println(String.format("Boosh crackle crackle. The town is on fire! The %s has attacked a town but lost some energy, which is now down to %d.", this.c, this.energyLevel));
		}
	}
}
