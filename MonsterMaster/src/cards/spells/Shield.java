/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.spells;

import cards.Spell;
import game.playerPackage.player;

/**
 * Class that represents the Shield spell Card.
 * Strategy pattern was used in making this as it fit the best with 
 * existing code more than Observer or Decorator.
 * This card part of the homework assignment 1 and is changed to fit assignment
 * 2.
 * @author Michael
 */
public class Shield extends Spell{
    
    
    
    //Constructor for shield.
    public Shield(){
        super("shield");
    }
    
    
    
    
    //This function is shield spell's effect.
    //The spell will switch the monster's flag for shield to true.
    //The function will then remove the card and print out a statement
    //saying the spell was used on a monster.
    public void effect(player owner, player enemy, int target, int position){
        owner.field.get(target).shield = true;
	owner.hand.remove(position);
	System.out.println(owner.id + " used shield on " + owner.field.get(target).getName());
    }
}
