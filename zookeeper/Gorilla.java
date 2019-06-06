// Create a separate class Gorilla that can:

// throwSomething() - print out a message indicating that the gorilla has thrown something, as well as decrease the energy level by 5

// eatBananas() - print out a message indicating the gorilla's satisfaction and increase its energy by 10

// climb() - print out a message indicating the gorilla has climbed a tree and decrease its energy by 10



package com.pollydesigns.zookeeper;

public class Gorilla extends Mammal {
	String c = this.getClass().getSimpleName();

	public void throwSomething() {
		if (this.energyLevel < 5) {
			System.out.println(String.format("The %s is much too tired to throw anything and should eat some bananas.", this.c));
		} else {			
			this.energyLevel -= 5;
			System.out.println(String.format("The %s has thrown something which lowered its energy to %d.", this.c, this.energyLevel));
		}
	}
	
	public void eatBananas() {
		this.energyLevel += 10;
		System.out.println(String.format("The %s has eaten some bananas. Yummy! Its energy level has now increased to to %d.", this.c, this.energyLevel));
	}
	
	public void climb() {
		if (this.energyLevel < 10) {
			System.out.println(String.format("The %s simply doesn't have enough energy to climb a pillow, let alone a tree. It should eat some bananas to regain its strength.", this.c));
		} else {			
			this.energyLevel -= 10;
			System.out.println(String.format("The %s has has climbed a tree. Phew, that was exhausting! Its energy level decreased to to %d.", this.c, this.energyLevel));
		}
	}

}
