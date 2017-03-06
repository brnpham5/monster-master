/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.YugiSpells;

import cards.YugiMonsters.Mon;
import game.playerPackage.YugiPlayer;

/**
 * This magic card will decrease a monster's attack and defense by 200 times
 * its level.
 * @author Michael
 */
public class NephthysCurse extends Magic{
    public NephthysCurse(){
        super("Nephthy's Curse",1);
    }
    
    
    
    @Override
    public void effect(YugiPlayer owner, YugiPlayer enemy, int target, int position){
            Mon monster = enemy.field.getMon(target);
            monster.atkMod -= monster.getLvl() * 200;
            monster.defMod -= monster.getLvl() * 200;
            owner.grave.add(this);
            System.out.println(owner.id + " used Nephthy's Curse on "+ monster.getName() + ".");
            
    }
}
