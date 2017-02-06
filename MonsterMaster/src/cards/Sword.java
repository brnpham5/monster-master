/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

import game.player;

/**
 * Class that represents the Sword spell Card.
 * Strategy pattern was used in making this as it fit the best with 
 * existing code more than Observer or Decorator.
 * This card part of the homework assignment 1 and is changed to fit assignment
 * 2.
 * @author Michael
 */
public class Sword extends Spell{
    
    
    
    //Constructor for sword.
    public Sword(){
        super("sword");
    }
    
    
    
    //This function is sword spell's effect.
    //The spell will switch the monster's flag for sword to true.
    //The function will then remove the card and print out a statement
    //saying the spell was used on a monster.
    public void effect(player owner, player enemy, int target, int position){
        owner.field.get(target).sword = true;
	owner.hand.remove(position);
	System.out.println(owner.id + " used sword on " + owner.field.get(target).getName());
    }
}
