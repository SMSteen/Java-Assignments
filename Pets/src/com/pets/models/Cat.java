package com.pets.models;

public class Cat extends Animal implements IPet {

	public Cat(String name, String breed, Integer weight) {
		super(name, breed, weight);
	}

	@Override
	public String showAffection() {
		return String.format("%s, your %s cat, looked at you with love. Or so you think.", this.getName(),
				this.getBreed());
	}

}
