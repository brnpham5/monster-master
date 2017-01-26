package game;

import java.util.ArrayList;

import cards.Monster;

//This is the strategy which focus on summoning the 
//highest attack monster, buffing the monster with spells,
//and killing the opponent's monster with the lowest defense value.
public class Offensive implements Strategy {
	
	public move pickMove(player user, ArrayList <Monster> arena){
		move choice = new move();
		boolean [][] spells = user.spellUse();
		if(user.hasHandMonster() && !user.summoned){
			if(arena.size() > (1+ user.field.size())){
				choice.summonDef = true;}
			else{
				choice.summonAtk = true;}
		}
		if(user.field.size() > 0 && spells[0][0] && spells[0][1]){
			 choice.buffAtk = true;
		}
		if(user.field.size() > 0 && spells[1][0] && spells[1][1]){
			choice.buffDef = true;
		}
		if(arena.size() > 0 && spells[2][0] && spells[2][1]){
			choice.curse = true;
		}
		if(user.field.size() > 0 && user.canAttack()){
			choice.attack = true;
		}else{ choice.pass = true;}
		return choice;
	}
}
