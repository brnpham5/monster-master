/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.strategy;

import cards.Monster;
import cards.YugiMonsters.Mon;
import cards.YugiSpells.SoulShield;
import game.move;
import game.playerPackage.YugiPlayer;
import game.playerPackage.player;

/**
 * This is the class to use the spell ice shield on a monster. 
 * @author Michael
 */
public class IceBuff implements move{
    
    /**
     * Move for Yugioh AI to use soul shield on a monster
     * @param user The player using the soul shield 
     * @param enemy The opposing player
     */
    @Override
    public void executeY(YugiPlayer user, YugiPlayer enemy){
	int pos = -1;
	int highest = 0;
	for(int loop = 0; loop < user.field.monSize(); loop++){
            Mon mon = user.field.getMon(loop);
            if(mon.getDef() > highest && mon.flipped){
                pos = loop;
                highest = mon.getDef();
            }
	}
                
	if(pos != -1){
            SoulShield card = new SoulShield();
            user.hand.list.remove(card);
            card.effect(user, null, pos, 0);
	}
	}
    
    
    //Function will look through the player's field.
	//The function will select the player's monster with the highest defense 
	//that does not already have a shield.
	//The function will return the position of the selected monster.
	//If there is no applicable monsters then position will return as -1.
	public void execute(player user,player enemy){
		int pos = -1;
		int highest = 0;
                int healthy = 0;
		int loc = 0;
		for(int look = 0; look < user.hand.size(); look++){
			if(user.hand.get(look).getName().equals("ice shield")){
				loc = look;
				break;
			}
		}
		for(int loop = 0; loop < user.field.size(); loop++){
			Monster mon = user.field.get(loop);
				if(mon.getDef() > highest && mon.getHp() > healthy && !mon.iceshield){
					pos = loop;
					highest = mon.getDef();
                                        healthy = mon.getHp();
				}
			}
		if(pos != -1){
                    user.hand.get(loc).effect(user, null, pos, loc);
		}
	}
}
