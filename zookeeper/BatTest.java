//Create a BatTest class to instantiate a bat and have it attack three towns, eat two humans, and fly twice

package com.pollydesigns.zookeeper;

public class BatTest {

	public static void main(String[] args) {
		Bat b = new Bat();
		b.displayEnergy(); // should return 300
		b.attackTown(); // should return 200
		b.attackTown(); // should return 100
		b.attackTown(); // should return 0
		b.eatHuman(); // should return 25
		b.eatHuman(); // should return 50
		b.fly(); // should return 0
		b.fly(); // should return too tired
		b.eatHuman(); // should return 25
		b.eatHuman(); // should return 50
		b.eatHuman(); // should return 75
		b.attackTown(); // should return too tired
	}

}
