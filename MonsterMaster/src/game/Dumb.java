package game;

import java.util.ArrayList;

import cards.Monster;

//The dumb strategy will consist of summoning the 
//first monster in the player's hand. The player
//will not use any spells in their monsters. The
//player will attack the first monster on the 
//opponents field and and attack their opponent directly
//if there is no monsters to attack.
public class Dumb implements Strategy {
	
	
	//If the user has a monster and can summon then they will.
	//If the user has a monster on their field that can attack then
	//they will. If the can't do any of the mention they pass.
	//A move object is passed with flags telling the player what to
	// do.
	public ArrayList<move> pickMove(player user, ArrayList <Monster> arena){
		ArrayList <move> moves = new ArrayList<move>();
		if(user.hasHandMonster() && !user.summoned){
			moves.add(new FirstSummon());
		}
                if(moves.isEmpty()){
                    if(user.field.size() > 0 && user.canAttack()){
                            moves.add(new FirstBattle());
                    }
                }
		return moves;
	}

}
