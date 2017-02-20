/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.strategy;

import cards.YugiMonsters.Mon;
import cards.YugiSpells.BerserkerSword;
import game.move;
import game.playerPackage.YugiPlayer;
import game.playerPackage.player;

/**
 *
 * @author Michael
 */
public class BSwordBuff implements move{
    public void execute(YugiPlayer user, YugiPlayer enemy){
		int pos = -1;
		int highest = 0;
		for(int loop = 0; loop < user.field.monSize(); loop++){
			Mon mon = user.field.getMon(loop);
			if(mon.getAtk() > highest && mon.flipped){
                            pos = loop;
                            highest = mon.getAtk();
			}
		}
                
		if(pos != -1){
                    user.hand.getCard(new BerserkerSword()).effect(user, null, pos, 0);
		}
	}

    @Override
    public void execute(player user, player enemy) {

    }
}
