/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.players.mm_player;

import cardgame.players.field;
import cardgame.players.player;

/**
 * Player class for ai players
 * Contains methods required to run a player automatically
 * Methods:
 * 1) canAttack()           //returns whether or not the player can attack (has monsters available to attack)
 * @author brnpham
 */
public class mm_player_ai extends mm_player{
    //This function checks that the player has at least 1 monster on the
    //field that can attack. This function is used by the strategy classes
    //to know when to attack.
    public boolean canAttack(){
        for(int loop = 0; loop < field.size();loop++){
            if(field.get(loop).isActive()){
                return true;
            }
        }
        return false;
    }
        
}
