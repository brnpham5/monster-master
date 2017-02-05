/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import cards.Monster;

/**
 * This class summons the first monster in the player's hand.
 * @author Michael
 */
public class FirstSummon implements move{
    //Function will search through player's hand
	//Summons the first monster encountered by the function.
	//This function will be used by the dumb strategy.
	public void execute(player user,player enemy){
		Monster monster = null;
		for(int loop = 0; loop < user.hand.size(); loop++){
			if(user.hand.get(loop).getType() == "monster"){ 
				monster = (Monster)user.hand.get(loop);
				break;
				}
			}
		if (monster != null){ 
			user.field.add(monster);
			user.hand.remove(monster);
			System.out.println(user.id +" summoned "+ monster.getName());
			}
		else{System.out.println(user.id +" does not summon.\n");}
	}
}
