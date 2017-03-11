/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.monster_master;
import cardgame.cards.mm_monsters.*;
import cardgame.players.mm_player.*;
import cardgame.strategy.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Performs the battles for Monster Master
 * 1) Battle between two monsters
 * 2) Directly attacking a player
 * 3) Damage calculation
 * 4) Effect activation
 * @author brnpham
 */
public class mm_battle {
//Game Methods
    //Attack method, have monster attack another monster
    //Attempt to attack another monster
    //Returns true if successful, false if fails
    public boolean attack(mm_monster select, mm_monster target){
        int damage = fight(select, target);
        String effect;
        if(damage < 0){
            if(select.defenseEffect("Failed Attack")){
                return false;
            }
            select.takeDmg(damage);
            System.out.println(select.getName() + " takes " + damage + " damage.");
            return true;
        } else if(damage > 0){
            effect = select.damageEffect(target);
            target.takeDmg(damage, effect);
            System.out.println(select.getName() + " deals " + damage + " damage.");
            return true;
        } else {
            System.out.println("No damage");
        }
        
        return false;
    }
    
    //Direct attack method, have monster attack a player directly
    //Deduct player's health by monster's current attack
    //Activate any direct attack effects
    public boolean directAttack(mm_monster select, mm_player target) {
        if(target.hasNoMonsters()){
            select.directEffect();
            target.takeDamage(select.getAttack());
            return true;
        }
        
        return false;
    }
        
    
//Private Methods
    //This is the function that does battle calculations.
    //The function will create 2 randomly generated numbers.
    //One will take the attacking monster's attack value and the
    //other number will take the defending monster's defense value.
    //The range of the 2 numbers be between 0 and their respective 
    //values. The difference of the two number wills be returned.
    private int fight(mm_monster p, mm_monster c){
	int atk = ThreadLocalRandom.current().nextInt(0,p.getAttack()+1);
	try {
            Thread.sleep(10);
	} catch (InterruptedException e) {
            e.printStackTrace();
	}
            int def = ThreadLocalRandom.current().nextInt(0,c.getDefense()+1);
            return atk-def;
    }
}