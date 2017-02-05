/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import cards.Monster;
import java.util.ArrayList;

/**
 * This is the class that the AI calls to battle their opponent. The AI will
 * only calls if they have a monster on the field and they are using the
 * Offensive strategy. AI will attack the opponent's monster with the least 
 * defense value. AI will continue attacks till all monster have finished 
 * attacking or enemy is dead.
 * @author Michael
 */
public class OffensiveBattle implements move{
        //The function will go through the player's whole field
	//and get each monster to attack. The monster's target is
	//dependent on strategy used. If the opponent loses all their health then
	//the attacking stops. This function will call the monster's effect function
        //to attack the target. The monster will only attack if their placed value equals
        //zero.
	public void execute(player user, player enemy){
		for(int attacks = 0; attacks < user.field.size();attacks++){
			int pos;
			
			//Position of target is calculated here.
			pos = AttackWeak(enemy.field);
			
			//If the attacking monster's summoning cooldown is less than 0.
			//Go through attack sequence. If not the monster does not attack
			//and its summoning cooldown is reduced by 1.
			//If the monster attacks use move function called fight.
			//Fight will return a number that tells if attacker wins battle
			//or not. Fight method only called if attacker's target is a monster.
			//If not then full attack value is subtracted from opponent's health.
			if(user.field.get(attacks).getPlaced() <= 0){
				user.field.get(attacks).attacked = true;
                                user.field.get(attacks).effect(user, enemy, pos,attacks);
                                if(enemy.lose){break;}
			}	
		}
	}
        
        //Looks through a player's field and returns the position of the monster
	//with the lowest defense. Return -1 if there is no monsters on the field.
	private int AttackWeak(ArrayList <Monster> field){
		int position = -1;
		int weakest = 12;
		for(int loop = 0; loop < field.size(); loop++){
			Monster mon = field.get(loop);
				if(mon.getDef() < weakest){
					position = loop;
					weakest = mon.getDef();
				}
			}
		return position;
	}
}
