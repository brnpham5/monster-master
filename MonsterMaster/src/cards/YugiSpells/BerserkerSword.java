/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.YugiSpells;

import cards.YugiMonsters.Mon;
import game.playerPackage.YugiPlayer;

/**
 *
 * @author Michael
 */
public class BerserkerSword extends Magic{
    //Position of the magic card in the player's field.
    private int place;
    
    
    
    /**
     * Default constructor of Berserker Sword cards.
     */
    public BerserkerSword() {
        super("Berserker's Sword", 2);
    }
    
    
    
    /**
     * Increases selected monster's attack modifier value by 500.
     * Decreases selected monster's defense modifier value by 100 times its level.
     * @param owner The player who owns the magic card.
     * @param enemy The opposing player.
     * @param target Position of the monster who the spell will affect.
     * @param position Position of the spell card in the owner's hand.
     */
    public void effect(YugiPlayer owner, YugiPlayer enemy, int target, int position){
        Mon monster = owner.field.getMon(target);
        monster.atkMod += 500;
        monster.defMod -= monster.getLvl() * 100;
        owner.field.addMagic(this);
        place = owner.field.magicSize()-1;
        monster.equipped[place] = true;
        System.out.println(owner.id +" used Berserker's Sword on "+monster.getName()+".");
    }
    
    
    
    /**
     * This takes away the attack buff off of the equipped monster and sends
     * this card to the grave.
     * @param owner The owner of the card.
     * @param enemy The opposing player.
     * @param target The position of the monster who equipped this card.
     * @param position The position of the spell on the owner's field.
     */
    @Override
    public void removedEffect(YugiPlayer owner, YugiPlayer enemy, int target, int position){
        owner.field.getMon(target).atkMod -= 500;
        owner.field.getMon(target).defMod += 100 * owner.field.getMon(target).getLvl();
        owner.grave.add(this);
        owner.field.removeMagic(position);
        owner.field.getMon(target).equipped[place] = false;
    }
}
