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
 *
 * @author Michael
 */
public class AttackSummon implements move{
    
    
    
    public void execute(YugiPlayer user,YugiPlayer enemy){
	int highestAtk = 0;
	int position = -1;
	for(int loop = 0; loop < user.hand.size(); loop++){
            if(user.hand.get(loop).getType().equals("monster")){ 
		Mon mon = (Mon)user.hand.get(loop);
		if(mon.getAtk() > highestAtk){
                    position = loop;
                    highestAtk = mon.getAtk();
		}
            }
	}
	if (position != -1){ 
            Mon monster = (Mon)user.hand.get(position);
            monster.summon(user, true);
            user.summoned = true;
            System.out.println(user.id +" summoned "+ monster.getName());
	}
	else{System.out.println(user.id +" does not summon.\n");}
    }
    
    
    
    //Function will check player's hand for monsters.
    //Function will return the highest attack value that the program
    //first encounters. If no monsters are encountered return null.
    //This function is used by the offensive strategy.
	public void execute(player user,player enemy){
		Monster monster;
		int highestAtk = 0;
		int position = -1;
		for(int loop = 0; loop < user.hand.size(); loop++){
			if(user.hand.get(loop).getType().equals("monster")){ 
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
                        user.summoned = true;
			System.out.println(user.id +" summoned "+ monster.getName());
			}
		else{System.out.println(user.id +" does not summon.\n");}
		}
}
