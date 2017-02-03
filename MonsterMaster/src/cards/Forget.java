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

public class Forget extends Spell{
    
    
    
    //Constructor for Curse.
    public Forget(){
        super("forget");
    }
    
    //This function is forget spell's effect.
    //The function first makes sure the enemy has at least 2 cards
    //in their hand and if they do then it removes 2 cards.
    //The function will then remove the card and print out a statement
    //saying the spell was used.
    public void effect(player owner, player enemy, int target, int position){
        if(enemy.hand.size() >= 2){
            enemy.hand.remove(position);
            enemy.hand.remove(position+1);
            System.out.println(owner.id + " used forget on " + enemy.id);
        }
    }
        
    

}