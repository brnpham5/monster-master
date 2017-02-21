/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.strategy;

import game.move;
import game.playerPackage.YugiPlayer;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class OffensiveYugi extends YugiStrategy{
    public ArrayList<move> pickMove(YugiPlayer user, YugiPlayer enemy) {
        ArrayList <move> moves = new ArrayList();
        int [] spells = user.countHand();
        boolean [][] usage = user.spellUse(spells, enemy);
        if(usage[5][0] == true || usage[6][0])
            moves.add(new HealNDmgSpell());
        if(usage[3][0] == true && usage[3][1] == true)
            moves.add(new BSwordBuff());
        return moves;
    }
    

    
    public ArrayList<move> mainPhase(YugiPlayer user, YugiPlayer enemy){
        return pickMove(user,enemy);
    }
    
    
    
    public void battlePhase(YugiPlayer user, YugiPlayer enemy){
        YugiAttack battle = new YugiAttack();
        battle.execute(user, enemy);
    }
}
