package com.pokemon;

public abstract class AbstractPokemon implements PokemonInterface {
    @Override
    public Pokemon createPokemon(String name, int health, String type) {
        return PokemonInterface.super.createPokemon(name, health, type);
    }

    @Override
    public String pokemonInfo(Pokemon pokemon) {
        return PokemonInterface.super.pokemonInfo(pokemon);
    }
}
