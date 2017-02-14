/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.spells;

import cards.Spell;
import game.player;

/**
 * Class that represents the Curse spell Card.
 * Strategy pattern was used in making this as it fit the best with 
 * existing code more than Observer or Decorator.
 * This card part of the homework assignment 1 and is changed to fit assignment
 * 2.
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
	System.out.println(owner.id + " used curse on " + enemy.field.get(target).getName());
    }
    
}
