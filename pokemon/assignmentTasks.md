Pokemon Assignment

Create a Pokemon class with:
name, health, and type member variables.

void attackPokemon(Pokemon pokemon): This method lowers the attacked Pokemon's health by 10

a count static variable that keeps the number of Pokemon created in the program.

getters and setters for each member variable.

a constructor class to set the instance's name, health, and type on creation

Pokemon.java
public class Pokemon {
// your code here
}
Create an interface for the following methods:

Pokemon createPokemon(String name, int health, String type): This method creates and returns Pokemon.

String pokemonInfo(Pokemon pokemon): This method returns a String with the name, health, and type of the pokemon.

void listPokemon(): List all the pokemon names that you have in your pokedex.

PokemonInterface.java
public interface PokemonInterface {
// your code here
}
Create an abstract class that only implements createPokemon and pokemonInfo(Pokemon pokemon) from the PokemonInterface.

AbstractPokemon.java
public abstract class AbstractPokemon implements PokemonInterface {
// your code here
}
Create a Pokedex class that extends the abstract class above and implements listPokemon(). Your Pokedex class needs an attribute called myPokemons where your store all the pokemons created.

Pokedex.java
public class Pokedex extends AbstractPokemon {
// your code here
}
Create a test file where you instantiate pokemon, attack pokemon, and list pokemon from a pokedex.
