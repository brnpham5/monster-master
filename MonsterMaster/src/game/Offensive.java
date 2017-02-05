package game;

import java.util.ArrayList;

import cards.Monster;

//This is the strategy which focus on summoning the 
//highest attack monster, buffing the monster with spells,
//and killing the opponent's monster with the lowest defense value.
public class Offensive implements Strategy {
	
	public ArrayList<move> pickMove(player user, ArrayList <Monster> arena){
		ArrayList <move> moves = new ArrayList<move>();
		boolean [][] spells = user.spellUse();
		if(user.hasHandMonster() && !user.summoned){
			if(arena.size() > (1+ user.field.size())){
				moves.add(new DefenseSummon());}
			else{
				moves.add(new AttackSummon());}
		}
		if(user.field.size() > 0 && spells[0][0] && spells[0][1]){
			 moves.add(new SwordBuff());
		}
		if(user.field.size() > 0 && spells[1][0] && spells[1][1]){
			moves.add(new ShieldBuff());
		}
		if(arena.size() > 0 && spells[2][0] && spells[2][1]){
			moves.add(new CurseDebuff());
		}
                if(moves.isEmpty()){    
                    if(user.field.size() > 0 && user.canAttack()){
                            moves.add(new OffensiveBattle());
                    }
                }
		return moves;
	}
}
