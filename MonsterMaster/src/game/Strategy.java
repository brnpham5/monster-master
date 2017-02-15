package game;

import java.util.ArrayList;
import cards.Monster;
import game.move;
import game.player;

//This is the strategy interface.
//The classes that implement the strategy class.
//Strategies tell which to monsters summon first,
//when to use spells, and which monsters to attack.
public interface Strategy {
    
    
        //This function will get information from the player object and the
        //enemy's field. The function will then add valid moves to the arraylist
        //for the player to do. 
	public ArrayList<move> pickMove(player user, player enemy);
}
