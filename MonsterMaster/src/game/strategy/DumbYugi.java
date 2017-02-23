/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.strategy;

import game.move;

import game.playerPackage.YugiPlayer;

import game.playerPackage.player;

import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class DumbYugi extends YugiStrategy{ 
    
    
    public ArrayList<move> pickMove(YugiPlayer user, YugiPlayer enemy) {
        ArrayList <move> moves = new ArrayList();
        int [] count = user.countHand();
        if(count[0] > 0)
            moves.add(new FirstSummon());
        return moves;
    }
    
    
    @Override
    public void battlePhase(YugiPlayer user, YugiPlayer enemy){
        YugiAttack battle = new YugiAttack();
        battle.execute(user, enemy);
    }
}
