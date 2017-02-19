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
public class YugiStrategy implements Strategy{

    
    public ArrayList<move> pickMove(YugiPlayer user, YugiPlayer enemy) {
        return new ArrayList();
    }
    
    
    public void drawPhase(YugiPlayer user){
        user.getCard();
    }
    
    public ArrayList<move> mainPhase(YugiPlayer user, YugiPlayer enemy){
        return pickMove(user,enemy);
    }
    
    
    
    public void battlePhase(YugiPlayer user, YugiPlayer enemy){
        //Battle move
    }

    @Override
    public ArrayList<move> pickMove(player user, player enemy) {
        //does nothing
        return new ArrayList();
    }
    
    
    
    
}
