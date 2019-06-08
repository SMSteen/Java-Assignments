package com.pokemon;

import java.util.ArrayList;

public class Pokedex extends AbstractPokemon implements PokemonInterface {
    public ArrayList<Pokemon> myPokemons = new ArrayList<Pokemon>();

    @Override
    public void listPokemon() {
        for (Pokemon pokemon : myPokemons) {
            System.out.println(pokemonInfo(pokemon));
        }
    }

    public void addPokemon(Pokemon pokemon) {
        myPokemons.add(pokemon);
    }
}
