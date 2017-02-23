package game.strategy;

import game.move;
import game.playerPackage.player;
import java.util.ArrayList;


//This is the strategy which focus on summoning the 
//highest attack monster, buffing the monster with spells,
//and killing the opponent's monster with the lowest defense value.
public class Offensive implements Strategy {
	
	public ArrayList<move> pickMove(player user, player enemy){
		ArrayList <move> moves = new ArrayList<>();
                int [] hand = user.countHand();
		boolean [][] spells = user.spellUse(hand,enemy);
		if(hand[0] > 0 && !user.summoned){
			if(enemy.field.size() > (1+ user.field.size())){
				moves.add(new DefenseSummon());}
			else{
				moves.add(new AttackSummon());}
		}
		if(spells[0][0] && spells[0][1]){moves.add(new SwordBuff());}
		if(spells[1][0] && spells[1][1]){moves.add(new ShieldBuff());}
		if(spells[2][0] && spells[2][1]){moves.add(new IceBuff());}
                if(spells[3][0] && spells[3][1]){moves.add(new FireBuff());}
                if(spells[4][0] && spells[4][1]){moves.add(new CurseDebuff());}
                /*if(spells[5][0] && spells[5][1]){moves.add(new );}    Heal move class
                if(spells[6][0] && spells[6][1]){moves.add(new );}      Restore move class
                if(spells[7][0] && spells[7][1]){moves.add(new );}      Sacrifice move class
                if(spells[8][0] && spells[8][1]){moves.add(new );}      Doom move class
                if(spells[9][0] && spells[9][1]){moves.add(new );}      Forget move class
                if(spells[10][0] && spells[10][1]){moves.add(new );}    Gift move class
                if(spells[11][0] && spells[11][1]){moves.add(new );}    Fireball move class
                if(spells[12][0] && spells[12][1]){moves.add(new );}    Lightning move class
                if(spells[13][0] && spells[13][1]){moves.add(new );}    Strip move class
                */
                
                if(moves.isEmpty()){    
                    if(user.field.size() > 0 && user.canAttack()){
                            moves.add(new OffensiveBattle());
                    }
                }
		return moves;
	}
}
