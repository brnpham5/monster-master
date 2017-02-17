/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.spells;

import cards.Spell;
import game.playerPackage.player;
/**
 *
 * @author Dev
 */

public class Fireball extends Spell{
    
    
    
    //Constructor for Curse.
    public Fireball(){
        super("fireball");
    }
    
    //This function is fireball spell's effect.
    //The spell will call the monster's setHp method to deal 3 damage to health
    //The function will then remove the card and print out a statement
    //saying the spell was used on a monster.
    public void effect(player owner, player enemy, int target, int position){
        
            owner.field.get(target).setHp(3);
            owner.hand.remove(position);
            System.out.println(owner.id + " used fireball on " + owner.field.get(target).getName());
            
        }
        
    

}
