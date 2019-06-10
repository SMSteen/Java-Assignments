package com.game.models;

import java.util.Random; // import the Random class

public class Game {
	private int number;

	public Game(int max, int min) {
		setNumber(max, min);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int max, int min) {
		// generate random number
		Random r = new Random(); // create instance of Random class
		this.number = r.nextInt(max - min + 1) + min; // bound to (max - min + 1); then add min
	}

}
