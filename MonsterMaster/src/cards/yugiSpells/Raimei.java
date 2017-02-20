/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.yugiSpells;

import game.playerPackage.YugiPlayer;

/**
 *
 * @author brnpham
 */
public class Raimei extends Magic{
    public Raimei(){
        super("Raimei",1);
    }
    
    
    @Override
    public void effect(YugiPlayer owner, YugiPlayer enemy, int target, int position){
            owner.setHp(300);
            owner.grave.add(this);
            System.out.println(owner.id + " used Hinotama.");
            
    }
}
