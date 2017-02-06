/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;
import game.player;

/*
 *Nina is a monster with 3 health, 4 attack, 1 defense, a cooldown of 1
 * Ninja has an effect: Kills any enemy he hits
 */
public class Ninja extends Monster{
    
    public Ninja(){
        super("ninja",4,1,1,3);
    }
    
    public void effect(player own, player enem,int targ,int posit){
            if(targ != -1){
		int dmg = fight(this,enem.field.get(targ)); // calculates damage
		System.out.println(name+" attacks "+enem.field.get(targ).getName()); //prints out Ninja attacking
		if(dmg < 0){
                    setHp(dmg);
                    System.out.println(enem.field.get(targ).getName()+" deals " + (-dmg) +" damage.");
                    if(health <= 0){
                        System.out.println(name + " dies");
                        own.field.remove(posit);
			}
                    System.out.println(name+"lost"+dmg+"health."); //if damage is less than 0 it states that no damage delt
		}else if(dmg > 0){
                    // if damage is greater than 0 due to ninjas effect it should kill the enemy monster
                    enem.field.get(targ).setHp(0); //sets enemy targets health to 0
                    System.out.println(enem.field.get(targ).getName() + " dies"); //anounces enemy death
                    enem.field.remove(targ); //removes target
                }else{
                    System.out.println("Ninja failed to do damage");
                }
            }else if(targ == -1){
             int damage = 4;
             enem.setHp(damage);
            }
    }   
}
