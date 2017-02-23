/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.YugiSpells;

import cards.Spell;
import game.playerPackage.YugiPlayer;

/**
 * This is the equivalent of a spell card from monster master in yugioh.
 * The magic cards in yugioh will inherit everything from spell cards and
 * add on to it.
 * @author Michael
 * @version 1.1
 */
public class Magic extends Spell{
    
    //This is the type of magic the card is
    // Numbers 4-6 aren't used in build 1.q
    // 1 = normal 
    // 2 = equip
    // 3 = field
    // 4 = quick
    // 5 = ritual
    // 6 = continuous
    private int category;
    
    
    
    /**
     * Default constructor of Magic cards.
     * @param id Name of the magic card.
     * @param num Category number of the spell card.
     */
    public Magic(String id, int num) {
        super(id);
        category = num;
    }
    
    
    public int getCategory(){ return category;}
    
    /**
     * The effect of the magic card.
     * @param owner The player who owns the magic card.
     * @param enemy The opposing player.
     * @param target Position of the monster who the spell will affect.
     * @param position Position of the spell card in the owner's hand.
     */
    public void effect(YugiPlayer owner, YugiPlayer enemy, int target, int position){}
    
    
    
    /**
     * This function is called when the card is removed from the field. 
     * This will usually be only called by equip cards.
     * @param owner The player who owns the magic card.
     * @param enemy The opposing player.
     * @param target Position of the monster who has equip spell
     * @param position Position of the spell card in the owner's field.
     */
    public void removedEffect(YugiPlayer owner, YugiPlayer enemy, int target, int position){
        
    }
    
    
}
