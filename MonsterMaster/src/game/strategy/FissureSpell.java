/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.strategy;

import game.move;
import game.playerPackage.player;
import game.playerPackage.YugiPlayer;

/**
 * This is the move for Ai's in Yugioh Game to use the fissure spell card that 
 * kills the opponents monster with the lowest attack card.
 * @author Michael
 */
public class FissureSpell implements move{
    
    
    
    public void execute(YugiPlayer user,YugiPlayer enemy){
        //user.hand.getCard(new Fissure()).effect(user,enemy,0,0); Need to add magic card
    }
    
    @Override
    public void execute(player user,player enemy){
        //Find fissure card in player's hand
        //use it
    }


}
