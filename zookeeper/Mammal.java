//Create a Mammal class that has an energyLevel and displayEnergy() method. The displayEnergy() method should show the animals energy level as well as return it.

package com.pollydesigns.zookeeper;

public class Mammal {
	int energyLevel;
	
	public Mammal() {
		this.energyLevel = 100;
	}
	
	public int displayEnergy() {
		String c = this.getClass().getSimpleName();
		System.out.println("This " + c + "'s energy level is " + this.energyLevel + ".");
		return this.energyLevel;
	}
}
