/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.monsters;

import cards.Monster;
import game.playerPackage.player;

/**
 * Class that represents the Vampire monster Card.
 * Strategy pattern was used in making this as it fit the best with 
 * existing code more than Observer or Decorator.
 * This card part of the homework assignment 1 and is changed to fit assignment
 * 2.
 * @author Michael
 */
public class Vampire extends Monster{
    public Vampire(){
        super("vampire",4,3,1,5);
    }
    
     //This function how monsters usually attack.
        //Most monsters will use this when told to attack.
        //Some monsters will need to override this to let their special ability happen.
        //This function will do battle calculation. The function will remove any monster
        //Killed and changes the health values of monsters or player to reflect the outcomes.
        public void effect(player owner, player enemy,int target,int position){
            if(target != -1){
		int dmg = fight(this,enemy.field.get(target));
		System.out.println(name+" attacks "+enemy.field.get(target).getName());
		if(dmg < 0){
                    setHp(dmg);
                    System.out.println(enemy.field.get(target).getName()+" deals " + (-dmg) +" damage.");
                    if(health <= 0){
                        System.out.println(name + " dies");
                        owner.field.remove(position);
			}
		}
		else if(dmg > 0){
                    enemy.field.get(target).setHp(dmg);
                    setHp(-dmg);
                    System.out.println("Vampire heals "+dmg + " health");
                    if(enemy.field.get(target).getHp() <= 0){
                        System.out.println(enemy.field.get(target).getName() + " dies");
                        enemy.field.remove(target);}
			}
                    }
                    else{
			System.out.println(name +" attacks directly for "+ attack+ " damage.");
				enemy.setHp(attack);
			}
            attacked = true;
        }
}
