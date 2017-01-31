package game;

import java.util.ArrayList;
import cards.Monster;

//This is the strategy interface.
//The classes that implement the strategy class.
//Must differ on monsters are summoned first,
//when to use spells, and which monsters to attack.y
public interface Strategy {
	public move pickMove(player user, ArrayList<Monster> arena);
}
