package com.pokemon;

public class PokemonTest {

	public static void main(String[] args) {
		// create pokedex
		Pokedex myPokedex = new Pokedex();
		Pokemon bulbasaur = new Pokemon("Bulbasaur", 45, "Grass/Poison");
		Pokemon butterfree = new Pokemon("Butterfree", 60, "Bug/Flying");
		Pokemon psyduck = new Pokemon("Butterfree", 50, "Water");
		Pokemon muk = new Pokemon("Muk", 105, "Poison");
		Pokemon jigglypuff = new Pokemon("Jigglypuff", 115, "Normal/Fairy");

		// adding pokemons to pokedex - not sure if this is best way
		myPokedex.addPokemon(bulbasaur);
		myPokedex.addPokemon(butterfree);
		myPokedex.addPokemon(psyduck);
		myPokedex.addPokemon(muk);
		myPokedex.addPokemon(jigglypuff);
		
		butterfree.attackPokemon(butterfree);
		butterfree.attackPokemon(muk);
		jigglypuff.attackPokemon(psyduck);
		jigglypuff.attackPokemon(muk);


		myPokedex.listPokemon();
	}

}
