/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.strategy;

import cards.Monster;
import cards.YugiMonsters.Mon;
import game.move;
import game.playerPackage.YugiPlayer;
import game.playerPackage.player;

/**
 * This class summons the first monster in the player's hand.
 * @author Michael
 * @version 2.0
 */
public class FirstSummon implements move{
    
    
    /**
     * This is move for Yugioh Ai to summon the first monster in their hand.
     * @param user Player taking the turn
     * @param enemy Opposing player
     */
    @Override
    public void executeY(YugiPlayer user,YugiPlayer enemy){  
        Mon monster = null;
	for(int loop = 0; loop < user.hand.size(); loop++){
            if(user.hand.get(loop).getType().equals("monster")){ 
		monster = (Mon)user.hand.get(loop);
		break;
            }
	}
	if (monster != null){
            boolean state = false;
            if(monster.getAtk() > monster.getDef())
                state = true;
            monster.summon(user, state);
            user.summoned = true;
            System.out.println(user.id +" summoned "+ monster.getName() +"");
	}
	else{System.out.println(user.id +" does not summon.\n");}
    }
    
    
    
    /**
     * This is the move for monster master Ai to summon the first monster
     * in their hand.
     * @param user Player summoning monster.
     * @param enemy Opposing player.
     */
    public void execute(player user,player enemy){  
        Monster monster = null;
	for(int loop = 0; loop < user.hand.size(); loop++){
            if(user.hand.get(loop).getType().equals("monster")){ 
		monster = (Monster)user.hand.get(loop);
		break;
            }
	}
	if (monster != null){ 
            user.field.add(monster);
            user.hand.remove(monster);
            user.summoned = true;
            System.out.println(user.id +" summoned "+ monster.getName());
	}
	else{System.out.println(user.id +" does not summon.\n");}
    }
}
