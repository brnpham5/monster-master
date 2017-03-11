/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.players;

import cardgame.cards.card_interface;
import java.util.ArrayList;

/**
 *
 * @author brnpham
 */
public class hand {
    public ArrayList <card_interface> list = new ArrayList();
    
    public ArrayList <card_interface> getList(){
        return list;
    }
    
    public int getSize(){
        return list.size();
    }
    
    public card_interface getCard(int target){
        return list.get(target);
    }
            
    public card_interface getCard(card_interface card){
        if(list.contains(card)){
            card_interface temp = list.get(list.indexOf(card));
            list.remove(card);
            return temp;
            
        } else {
            System.out.println (card.getName()+" not found in hand.");
            return null;
        }
    }
    
    public void print(){
        for(card_interface card : list){
            System.out.println (card.getName());
        }
    }
    
    public void add(card_interface card){
        list.add(card);
    }
    
    public void add(int position, card_interface card){
        list.add(position, card);
    }
    
    public void remove(card_interface card){
        list.remove(card);
    }
    
    public void remove(int position){
        list.remove(position);
    }
    
    public int size(){
        return list.size();
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    public void clear(){
        list.clear();
    }
    
}
