/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

import game.player;
/**
 *
 * @author Dev
 */

public class Gift extends Spell{
    
    
    
    //Constructor for Curse.
    public Gift(){
        super("gift");
    }
    
    //This function is gift spell's effect.
    //This function makes sure there is at least 3 cards in the deck
    //and then draws 2 cards and puts them into the player's hand.
    //The function will then remove the card and print out a statement
    //saying the spell was used.
    public void effect(player owner){
        if(owner.Deck.deckSize() > 2){   
            owner.getCard();
            owner.getCard();
            System.out.println(owner.id + " used gift");
        }
    }
        
    

}
