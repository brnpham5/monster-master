/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.spells;

import cards.Spell;
import game.playerPackage.player;

/**
 * Decorator Pattern
 * @author brnpham
 */
public class Sacrifice extends Spell{
    //Constructor for Sacrifice.
    public Sacrifice(){
        super("sacrifice");
    }
    
    //This function is sacrifice spell's effect.
    //The spell will call the monster's remove method to sacrifice it
    //Then the player will be healed for 5 health
    //The function will then remove the card and print out a statement
    //saying the spell was used on a monster.
    public void effect(player owner, player enemy, int target, int position){
        System.out.println(owner.id + " used sacrifice on " + owner.field.get(target).getName());
        owner.field.remove(target);
        owner.setHp(-5);
        owner.hand.remove(position);
    }
}
