/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import cards.Monster;

/**
 * This is the class that uses the shield spell on a monster.
 * @author Michael
 */
public class ShieldBuff implements move{
        //Function will look through the player's field.
	//The function will select the player's monster with the highest defense 
	//that does not already have a shield.
	//The function will return the position of the selected monster.
	//If there is no applicable monsters then position will return as -1.
	public void execute(player user,player enemy){
		int pos = -1;
		int highest = 0;
		int loc = 0;
		for(int look = 0; look < user.hand.size(); look++){
			if(user.hand.get(look).getName().equals("shield")){
				loc = look;
				break;
			}
		}
		for(int loop = 0; loop < user.field.size(); loop++){
			Monster mon = user.field.get(loop);
				if(mon.getDef() > highest && mon.getHp() == mon.maxhp && !mon.shield){
					pos = loop;
					highest = mon.getDef();
				}
			}
		if(pos != -1){
                    user.hand.get(loc).effect(user, null, highest, pos);
		}
	}
	   
}