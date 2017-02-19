/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.strategy;

import cards.YugiMonsters.Mon;
import game.move;
import game.playerPackage.player;
import cards.YugiSpells.NephthysCurse;
import game.playerPackage.YugiPlayer;

/**
 *
 * @author Michael
 */
public class NCurse implements move{

    
    
    public void execute(YugiPlayer user, YugiPlayer enemy){
        int pos = -1;
	int highest = 0;
	for(int loop = 0; loop < enemy.field.monSize(); loop++){
            Mon mon = enemy.field.getMon(loop);
                if(mon.getStat() > highest && mon.flipped){
                    pos = loop;
                    highest = mon.getStat();
		}
	}
                
	if(pos != -1){
            user.hand.getCard(new NephthysCurse()).effect(user,enemy,pos,0);
        }
    }
    
    @Override
    public void execute(player user, player enemy) {} 
}
