/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import cards.Monster;

/**
 *
 * @author Michael
 */
public class AttackSummon implements move{
    //Function will check player's hand for monsters.
	//Function will return the highest attack value that the program
	//first encounters. If no monsters are encountered return null.
	//This function is used by the offensive strategy.
	public void execute(player user,player enemy){
		Monster monster = null;
		int highestAtk = 0;
		int position = -1;
		for(int loop = 0; loop < user.hand.size(); loop++){
			if(user.hand.get(loop).getType() == "monster"){ 
				Monster mon = (Monster)user.hand.get(loop);
				if(mon.getAtk() > highestAtk){
					position = loop;
					highestAtk = mon.getAtk();
				}
			}
		}
		if (position != -1){ 
			monster = (Monster)user.hand.get(position);
			user.field.add(monster);
			user.hand.remove(monster);
			System.out.println(user.id +" summoned "+ monster.getName());
			}
		else{System.out.println(user.id +" does not summon.\n");}
		}
}
