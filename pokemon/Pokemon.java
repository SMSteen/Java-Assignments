package com.pokemon;

public class Pokemon {
	private String name;
	private int health;
	private String type;

	private static int numPokemons;

	public Pokemon(String name, int health, String type) {
		this.name = name;
		this.health = health;
		this.type = type;
		numPokemons++;
	}

	public static int getNumPokemons() {
		return numPokemons;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void attackPokemon(Pokemon pokemon) {
		if (pokemon == this) {
			System.out.print("You can't attack yourself. Seek therapy and then find another pokemon to attack!");
		} else {
			pokemon.setHealth(pokemon.health - 10);
		}
	}

}
