/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import cards.Monster;
import java.util.ArrayList;

/**
 * This is the class that uses the curse spell on a monster.
 * @author Michael
 */
public class CurseDebuff implements move{
    	//Function will look through the enemy's field.
	//The function will select the enemy's strongest monster that is not cursed.
	//The function will return the position of the selected monster.
	//If there is no applicable monsters then position will return as -1.
	public void execute(player user, player enemy){
		int pos = -1;
		int highest = 0;
		int loc = 0;
		for(int look = 0; look < user.hand.size(); look++){
			if(user.hand.get(look).getName().equals("curse")){
				loc = look;
				break;
			}
		}
		
		for(int loop = 0; loop < enemy.field.size(); loop++){
			Monster mon = enemy.field.get(loop);
				if(mon.getAtk() > highest && !mon.curse){
					pos = loop;
					highest = mon.getAtk();
				}
			}
		if(pos != -1){
                    user.hand.get(loc).effect(user, enemy, pos, loc);
		}
	}
}
