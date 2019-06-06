//Create a GorillaTest class to instantiate a gorilla and have it throw three things, eat bananas twice, and climb once.

package com.pollydesigns.zookeeper;

public class GorillaTest {

	public static void main(String[] args) {
		Gorilla g = new Gorilla();
		g.displayEnergy(); // should return 100
		g.throwSomething(); // should return 95
		g.throwSomething(); // should return 90
		g.throwSomething(); // should return 85
		g.eatBananas(); // should return 95
		g.eatBananas(); // should return 105
		g.climb(); // should return 95
		g.climb(); // should return 85
		g.climb(); // should return 75
		g.climb(); // should return 65
		g.climb(); // should return 55
		g.climb(); // should return 45
		g.climb(); // should return 35
		g.climb(); // should return 25
		g.climb(); // should return 15
		g.climb(); // should return 5
		g.climb(); // should return too tired
		g.throwSomething(); // should return 0
		g.throwSomething(); // should return too tired
	}

}
