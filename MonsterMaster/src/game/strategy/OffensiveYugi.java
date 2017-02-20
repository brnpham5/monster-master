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
        int [] count = user.countHand();
        boolean [][] usage = user.spellUse(count, enemy); 
        
        if(count[0] > 0 && !user.summoned){
            moves.add(new AttackSummon());
        }
        if(usage[0][0] == true && usage[0][1] == true)
           moves.add(new BSwordBuff());
        if(usage[1][0] == true && usage[1][1] == true)
           moves.add(new ShieldBuff());
        if(usage[2][0] == true && usage[2][1] == true)
           moves.add(new IceBuff());
        if(usage[3][0] == true && usage[3][1] == true)
            moves.add(new FireBuff());
        if(usage[8][0] == true && usage[8][1] == true)
            moves.add(new FissureSpell());
        if(usage[4][0] == true && usage[4][1] == true)
            moves.add(new NCurse());
        if(usage[5][0] == true || usage[6][0])
            moves.add(new HealNDmgSpell());
        
        return moves;
    }
    

    
    public ArrayList<move> mainPhase(YugiPlayer user, YugiPlayer enemy){
        return pickMove(user,enemy);
    }
    
    
    @Override
    public void battlePhase(YugiPlayer user, YugiPlayer enemy){
        YugiAttack battle = new YugiAttack();
        battle.execute(user, enemy);
    }
}
