/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.YugiSpells;

import game.playerPackage.player;
import game.playerPackage.YugiPlayer;

/**
 * This is the fireball spell from monster master turned into the hinotama
 * spell card in yugioh. The spell card does 500 points of damage to enemy 
 * player.
 * @author Michael
 */
public class Hinotama extends Magic{
    public Hinotama(){
        super("Hinotama",1);
    }
    
    
    @Override
    public void effect(YugiPlayer owner, YugiPlayer enemy, int target, int position){
            owner.setHp(500);
            owner.grave.add(this);
            System.out.println(owner.id + " used Hinotama.");
            
    }
}
