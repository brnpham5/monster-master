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
public class DefenseSummon implements move{
    //This function looks through the user's hand and chooses the monster 
	//with the highest defense value. If there is no monsters in the hand then
	//the user does not summon.
        @Override
	public void execute(player user, player enemy){
		Monster monster;
		int highestDef = 0;
		int position = -1;
		for(int loop = 0; loop < user.hand.size(); loop++){
			if(user.hand.get(loop).getType().equals("monster")){ 
				Monster mon = (Monster)user.hand.get(loop);
				if(mon.getDef() > highestDef){
					position = loop;
					highestDef = mon.getDef();
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

    @Override
    public void executeY(YugiPlayer user, YugiPlayer enemy) {
    int highestDef = 0;
	int position = -1;
	for(int loop = 0; loop < user.hand.size(); loop++){
            if(user.hand.get(loop).getType().equals("monster")){ 
		Mon mon = (Mon)user.hand.get(loop);
		if(mon.getAtk() > highestDef){
                    position = loop;
                    highestDef = mon.getDef();
		}
            }
	}
	if (position != -1){ 
            Mon monster = (Mon)user.hand.get(position);
            monster.summon(user, false);
            user.summoned = true;
            System.out.println(user.id +" summoned "+ monster.getName());
	}
	else{System.out.println(user.id +" does not summon.\n");}    
    }
}
