/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.strategy;

import cards.Monster;
import game.move;
import game.playerPackage.YugiPlayer;
import game.playerPackage.player;

/**
 * This is the class that uses the sword spell on a monster.
 * @author Michael
 */
public class SwordBuff implements move{
    
    
    
    	//Function will look through the player's field.
	//The function will select the player's monster with the highest attack
	//that does not already have a sword.
	//The function will return the position of the selected monster.
	//If there is no applicable monsters then position will return as -1.
	public void execute(player user, player enemy){
		int pos = -1;
		int highest = 0;
                int healthy = 0;
		int loc = 0;
		for(int look = 0; look < user.hand.size(); look++){
			if(user.hand.get(look).getName().equals("sword")){
				loc = look;
				break;
			}
		}
		for(int loop = 0; loop < user.field.size(); loop++){
			Monster mon = user.field.get(loop);
                        System.out.println(mon.getName()+" "+mon.getAtk());
			if(mon.getAtk() > highest && mon.getHp() > healthy && !mon.sword){
                            System.out.println("tre");
                            pos = loop;
                            highest = mon.getAtk();
                            healthy = mon.getHp();
			}
			}
                System.out.println(pos);
		if(pos != -1){
                    System.out.println(user.hand.get(loc).toString());
                    user.hand.get(loc).effect(user, null, pos, loc);
		}
	}

    @Override
    public void executeY(YugiPlayer user, YugiPlayer enemy) {
        //nothing
    }
}
