package com.pokemon;

public interface PokemonInterface {

    default Pokemon createPokemon(String name, int health, String type) {
        Pokemon newPokemon = new Pokemon(name, health, type);
        return newPokemon;
    };

    default String pokemonInfo(Pokemon pokemon) {
        return String.format("%s is a %s pokemon. %s's health is %d", pokemon.getName(), pokemon.getType(),
                pokemon.getName(), pokemon.getHealth());
    }

    void listPokemon();
}
