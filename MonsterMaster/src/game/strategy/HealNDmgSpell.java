/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.strategy;

import game.move;
import game.playerPackage.player;
import cards.YugiSpells.*;
import game.playerPackage.YugiPlayer;

/**
 * This is the move for Ai's in Yugioh Game to use any spell card that 
 * restores their life points or deals direct damage to their opponents life 
 * points.
 * @author Michael
 */
public class HealNDmgSpell implements move{
    @Override
    public void execute(player user,player enemy){
        //nothing
    }

    @Override
    public void executeY(YugiPlayer user, YugiPlayer enemy) {
        Hinotama card = new Hinotama();
        if(user.hand.getCard(card) != null)
            card.effect(user, enemy, 0, 0);
        //Rest of the heal/direct damage spells go here.
    }
}
