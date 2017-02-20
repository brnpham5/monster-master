/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import game.playerPackage.*;
import cards.*;

/**
 *
 * @author brnpham
 */
public class Factory {
    
    public static playerInterface getPlayer(String playerType){
        if(playerType == null){
            return null;
        }		
        if(playerType.equalsIgnoreCase("MonsterMaster")){
            return new player();
         
        } else if(playerType.equalsIgnoreCase("YuGiOh")){
            return new yugiPlayer();
         
        } 
        return null;
    }    
}
