// Test these methods work using a HumanTest class

package com.objectmaster;

public class HumanTest {
	public static void main(String[] args) {
		Human stephanie = new Human("Stephanie");
		Human faith = new Human("Faith");
		Human clay = new Human("Clay");
		Wizard jac = new Wizard("Jacey");
		Wizard shannon = new Wizard("Shannon");
		Ninja george = new Ninja("George");
		Samurai althea = new Samurai("Althea");
		Samurai mike = new Samurai("Mike");
		faith.attack(stephanie);
		faith.attack(stephanie);
		faith.attack(stephanie);
		stephanie.attack(stephanie); // should return "seek therapy"
		shannon.heal(shannon);  // should return "you can't heal yourself"
		shannon.heal(faith);  // should return "doesn't need healing"
		shannon.heal(stephanie); // should return "healed by 8 pts"
		System.out.println(shannon.getHealth()); // should return 50
		System.out.println(faith.getHealth()); // should return 100
		System.out.println(stephanie.getHealth()); // should return 99
		shannon.heal(stephanie); // should return "restored to full health"
		jac.fireball(clay); // should return attacked clay with fireball
		jac.fireball(clay); // should return attacked clay with fireball
		jac.fireball(clay); // should return attacked clay with fireball
		jac.fireball(clay); // should return attacked clay with fireball
		shannon.fireball(clay); // should return clay's dead
		shannon.fireball(george); // should return attacked george with fireball
		george.steal(george); // should return can't steal from yourself silly
		george.steal(faith); // should return stole 10 pts 
		george.steal(faith); // should return stole 10 pts 
		george.steal(faith); // should return stole 4 pts 
		george.steal(faith); // should return "doesn't need healing"
		george.runAway(); // should return "ran away from fight"
		System.out.println(george.getHealth()); // should return 90
		althea.deathBlow(althea); // should return "seek therapy"
		althea.deathBlow(george); // should return "george is dead, althea lost 100 hp"
		althea.meditate(); // should return you gained 99 health pts
		mike.deathBlow(althea); // should return althea is dead, mike lost 100 hp
//		althea.deathBlow(shannon); // should return "you don't have the energy"
//		althea.meditate(); // should return you gained 99 health pts
		System.out.println(althea.howMany()); // should return 2

	}

}
