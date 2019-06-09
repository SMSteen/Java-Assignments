package com.pets.models;

public class Dog extends Animal implements IPet {

	public Dog(String name, String breed, Integer weight) {
		super(name, breed, weight);
	}

	@Override
	public String showAffection() {
		if (this.getWeight() < 30) {
			return String.format("%s jumped up in your lap and cuddled you!", this.getName());
		} else {
			return String.format("%s curled up next to you on the couch!", this.getName());
		}
	}

}
