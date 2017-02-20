/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.YugiSpells;

import game.player;

/**
 * This is the fireball spell from monster master turned into the hinotama
 * spell card in yugioh.
 * @author Michael
 */
public class Hinotama extends Magic{
    public Hinotama(){
        super("Hinotama",1);
    }
    
    public void effect(player owner, player enemy, int target, int position){
            owner.setHp(500);
            owner.hand.remove(position);
            owner.grave.add(this);
            System.out.println(owner.id + " used Hinotama.");
            
    }
}
