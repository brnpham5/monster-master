/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.strategy;


import cards.YugiMonsters.Mon;
import game.playerPackage.YugiPlayer;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class YugiAttack {
    public void execute(YugiPlayer user, YugiPlayer enemy){
	for(int attacks = 0; attacks < user.field.monSize();attacks++){
            Mon card = user.field.getMon(attacks);		
            //Position of target is calculated here.
            int pos = AttackWeak(enemy.field.getMonsters(),card.getAtk());
			
            //If the attacking monster's is in attack position and face up
            //go through attack sequence.
            //If the monster attacks use attack function in mon class.
            //
            if(card.attackPos && !card.attacked){
                card.attacked = true;
                if(pos != -2)
                    card.attack(user, enemy, pos,attacks);
                if(enemy.lose){break;}
		}
                         
	}
}
        
    //Looks through a player's field and returns the position of the monster
    //with the lowest active stat. Return -1 if there is no monsters on the field.
    private int AttackWeak(ArrayList <Mon> field,int power){
        if(field.isEmpty()){return -1;}
        int position = -2;
        int weakest = 100000;
        for(int loop = 0; loop < field.size(); loop++){
            Mon mon = field.get(loop);
            if(!mon.flipped)
                position = loop;
            else if(mon.getStat() <= weakest && mon.flipped && mon.getStat() <= power){
                position = loop;
                weakest = mon.getStat();
            }
        }
	return position;
    }
}
