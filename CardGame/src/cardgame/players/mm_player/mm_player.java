/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.players.mm_player;
import cardgame.cards.mm_monsters.*;
import cardgame.cards.mm_spells.*;
import cardgame.players.*;

/**
 * Player class, manages player data and player actions
 * Actions:
 * 1) Draw
 * 2) Display Hand
 * 3) Play Monster
 * 4) Play Spell
 * 5) Has no monster        //If player has no monsters, can be directly attacked
 * @author brnpham
 */
public class mm_player extends player{
    //Reference to a mm_deck, holds the player's deck
    protected mm_deck deck = new mm_deck();
    
    //Reference to a mm_hand, contains a player's hand
    protected mm_hand hand = new mm_hand();
    
    //Reference to a mm_grave, contains player's grave for spent cards
    protected mm_grave grave = new mm_grave();
    
    //Reference to a mm_field, contains and manages a player's field
    protected mm_field field = new mm_field();
    
    //Flag that determines whether a player can summon a monster this turn.
    //Typically a player can summon one monster
    //True = can summmon
    //False = can not summon, summoned already
    public boolean canSummon = true;

    public mm_player() {
        super();
        this.health = 20;
    }

    public mm_player(String name) {
        super(name);
        this.health = 20;
    }
    
    //Draw a card from deck to hand
    public void draw(){
        if(!deck.isEmpty()){
            hand.add(deck.draw());
        } else {
            alive = false;
        }
    }
    
    public void displayHand(){
        hand.print();
    }
    
    //Play monster from hand
    //Select index of monster card from hand
    //Play it to the field
    //Remove from hand
    public boolean playMonster(mm_monster select){
        
        return false;
    }
    
    //play spell
    public boolean playSpell(mm_spell select){
        select.effect();
        return false;
    }
    
    //play spell on a monster
    public boolean playSpell(mm_spell select, mm_monster target){
        select.effect(target);
        return false;
    }
    
    //play spell on a player
    public boolean playSpell(mm_spell select, mm_player target){
        select.effect(target);
        return false;
    }
    
    //When player turn ends, summon flag is set to false and monster's
    //attack flag is set to false. Also every monster placed value is reduced
    //by 1.
    private void endTurn(){
	canSummon = true;
	for(int loop = 0; loop < field.size();loop++){
            if(!field.get(loop).isActive()){
		field.get(loop).setActive();
            }
            field.get(loop).decSummonTime();
	}
    }
    
    //If the field is empty, return true
    //else return false
    //Determines whether a player can be directly attack
    //If a player has no monsters, they can be directly attacked
    public boolean hasNoMonsters(){
        return field.isEmpty();
    }
    
}
