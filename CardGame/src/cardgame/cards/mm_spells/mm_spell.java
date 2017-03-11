/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.cards.mm_spells;

import cardgame.cards.mm_monsters.mm_monster;
import cardgame.monster_master.mm_card;
import cardgame.players.mm_player.mm_player;

/**
 * Card Properties:
 * Name:                //Inherited
 * Type:                //Inherited
 * Effect:              //Effect of Spell
 * @author brnpham
 */
public abstract class mm_spell extends mm_card implements mm_spell_interface{
    public mm_spell(int value, int limit, String name, String type) {
        super(value, limit, name, "Spell");
    }
    
    public abstract void effect();
    
    public abstract void effect(mm_monster target);
    
    public abstract void effect(mm_player target);
    
}
