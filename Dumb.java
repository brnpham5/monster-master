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
	public move pickMove(player user, ArrayList <Monster> arena){
		move choice = new move();
		if(user.hasHandMonster() && !user.summoned){
			choice.summon = true;
		}
		if(user.field.size() > 0 && user.canAttack()){
			choice.attack = true;
		}else{ choice.pass = true;}
		return choice;
	}

}
