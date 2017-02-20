/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.YugiSpells;

import cards.Spell;
import game.player;

/**
 * This is the equivalent of a spell card from monster master in yugioh.
 * The magic cards in yugioh will inherit everything from spell cards and
 * add on to it.
 * @author Michael
 * @version 1.0
 */
public class Magic extends Spell{
    
    //This is the type of magic the card is
    // Numbers 4-6 aren't used in build 1.0
    // 1 = normal 
    // 2 = equip
    // 3 = field
    // 4 = quick
    // 5 = ritual
    // 6 = continuous
    private int category;
    
    
    public Magic(String id, int num) {
        super(id);
        category = num;
    }
    
    //This is empty for the parent magic card class.
    //This called when the card is removed from the field.
    //Either this will do nothing for most except equip cards or this is where
    //the card is removed from the field.
    public void removedEffect(player owner, player enemy, int target, int position){
        
    }
    
    
}
