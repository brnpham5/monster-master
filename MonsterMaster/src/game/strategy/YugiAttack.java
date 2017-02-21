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
			int pos;
			
			//Position of target is calculated here.
			pos = AttackWeak(enemy.field.getMonsters());
			
			//If the attacking monster's summoning cooldown is less than 0.
			//Go through attack sequence. If not the monster does not attack
			//and its summoning cooldown is reduced by 1.
			//If the monster attacks use move function called fight.
			//Fight will return a number that tells if attacker wins battle
			//or not. Fight method only called if attacker's target is a monster.
			//If not then full attack value is subtracted from opponent's health.
			if(user.field.getMon(attacks).attackPos && !user.field.getMon(attacks).attacked){
                            user.field.getMon(attacks).attacked = true;    
                            user.field.getMon(attacks).attack(user, enemy, pos,attacks);
                            if(enemy.lose){break;}
			}
                         
		}
	}
        
        //Looks through a player's field and returns the position of the monster
	//with the lowest defense. Return -1 if there is no monsters on the field.
	private int AttackWeak(ArrayList <Mon> field){
            if(field.isEmpty()){return -1;}
            int position = -2;
            int weakest = 10000;
            for(int loop = 0; loop < field.size(); loop++){
                    Mon mon = field.get(loop);
                        if(!mon.flipped)
                            position = loop;
                        else if(mon.getStat() <= weakest && mon.flipped){
                            position = loop;
                            weakest = mon.getStat();
			}
		}
		return position;
	}
}
