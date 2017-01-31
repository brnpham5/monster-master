/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

import game.player;

/**
 *
 * @author Michael
 */
public class Curse extends Spell{
    
    
    
    //Constructor for Curse.
    public Curse(){
        super("curse");
    }
    
    
    
    //This function is curse spell's effect.
    //The spell will switch the monster's flag for curse to true.
    //The function will then remove the card and print out a statement
    //saying the spell was used on a monster.
    public void effect(player owner, player enemy, int target, int position){
        enemy.field.get(target).curse = true;
	owner.hand.remove(position);
	System.out.println(owner.id + " used curse on " + owner.field.get(target).getName());
    }
    
}
