/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.spells;

import cards.Spell;
import game.player;

/**
 * Decorator Pattern
 * @author brnpham
 */
public class Heal extends Spell{
    //Constructor for heal.
    public Heal(){
        super("heal");
    }
    
    //This function is heal spell's effect.
    //The spell will call the monster's setHp method to heal it 2 health
    //If the monster is a skelton, golem, or robot, then spell will not work.
    //The function will then remove the card and print out a statement
    //saying the spell was used on a monster.
    public void effect(player owner, player enemy, int target, int position){
        if (owner.field.get(target).getName() != "skeleton" || owner.field.get(target).getName() != "golem" || owner.field.get(target).getName() != "robot"){
            owner.field.get(target).setHp(-2);
            owner.hand.remove(position);
            System.out.println(owner.id + " used heal on " + owner.field.get(target).getName());
        }
        
    }
}
