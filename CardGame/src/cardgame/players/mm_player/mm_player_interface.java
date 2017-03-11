/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.players.mm_player;
import cardgame.cards.mm_monsters.*;
import cardgame.cards.mm_spells.*;

/**
 *
 * @author brnpham
 */
public interface mm_player_interface {
    public boolean draw();
    public boolean playMonster(mm_monster select);
    public boolean playSpell(mm_spell select);
    public boolean playSpell(mm_spell select, mm_monster target);
    public boolean playSpell(mm_spell select, mm_player target);
    
    public boolean hasNoMonster();
}
