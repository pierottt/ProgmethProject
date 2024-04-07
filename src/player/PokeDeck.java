package player;

import Pokemon.BasePokemon;
import Pokemon.Pikachu;

import java.util.ArrayList;

public class PokeDeck {
    private ArrayList<BasePokemon> pokeDeck;


    public PokeDeck(){
        setPokeDeck(new ArrayList<BasePokemon>());
        this.pokeDeck.add(new Pikachu(1,1,1,1));
    }

    public ArrayList<BasePokemon> getPokeDeck() {
        return pokeDeck;
    }

    public void setPokeDeck(ArrayList<BasePokemon> pokeDeck) {
        this.pokeDeck = pokeDeck;
    }
}
