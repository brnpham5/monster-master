/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.spells;

import cards.Spell;
import game.player;

/**
 * Class that represents the AIce Shield spell Card.
 * Strategy pattern was used in making this as it fit the best with 
 * existing code more than Observer or Decorator.
 * @author Michael
 */
public class IceShield extends Spell{
            
    
    
    //Constructor for sword.
    public IceShield(){
        super("ice shield");
    }
    
    
    
    //This function is fire sword spell's effect.
    //The spell will switch the monster's flag for sword to true.
    //The function will then remove the card and print out a statement
    //saying the spell was used on a monster.
    public void effect(player owner, player enemy, int target, int position){
        owner.field.get(target).iceshield = true;
	owner.hand.remove(position);
	System.out.println(owner.id + " used ice shield on " + owner.field.get(target).getName());
    }
}
