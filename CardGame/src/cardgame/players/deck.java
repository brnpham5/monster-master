/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.players;

import java.util.ArrayList;
import cardgame.cards.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author brnpham
 */
public class deck {
    //Arraylist of cards to make up a deck
    protected ArrayList <card_interface> list;
    
    //Gets the first card from the deck and returns it.
    //Removes the drawn card from deck.
    public card_interface draw(){
        if(!list.isEmpty()){
            card_interface one = list.get(0);
            list.remove(0);
            return one;
        }
        System.out.println("deck - Deck is empty");
        return null;
    }
    
    //Search the list for a matching name
    //Returns first instance index of card in deck
    public int search(String name){
        for(card_interface c : list){
            if(name.equals(c.getName())){
                return list.indexOf(c);
            }
        }
        return -1;
        
    }
    
    //Search the list for a matching type
    //Returns first instance index of card in deck
    public int searchType(String type){
        for(card_interface c : list){
            if(type.equals(c.getType())){
                return list.indexOf(c);
            }
        }
        return -1;
        
    }
    
    //Shuffles the deck
    public void shuffle(){
        ArrayList <card_interface> pile = new ArrayList();
        int position;
        for(int loop = 0; loop < this.list.size(); loop++){
            position = ThreadLocalRandom.current().nextInt(0, this.list.size());
            pile.add(list.get(position));
            list.remove(position);
        }
        
        list = pile;
    }
    
    //Returns the size of the deck
    public int size(){
        return list.size();
    }
    
    //Checks if deck is empty (same as isEmpty())
    public boolean isEmpty(){
        return list.isEmpty();
    }
}
