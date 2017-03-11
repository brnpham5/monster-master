/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.players.mm_player;

import cardgame.cards.mm_monsters.mm_monster;
import java.util.ArrayList;

/**
 *
 * @author brnpham
 */
public class mm_field {
    public ArrayList <mm_monster> list = new ArrayList();
    
    public ArrayList <mm_monster> getList(){
        return list;
    }
    
    public int getSize(){
        return list.size();
    }
            
    public mm_monster getCard(mm_monster card){
        if(list.contains(card)){
            mm_monster temp = list.get(list.indexOf(card));
            list.remove(card);
            return temp;
            
        } else {
            System.out.println ("Card not found.");
            return null;
        }
    }
    
    public void print(){
        for(mm_monster card : list){
            System.out.println (card.getName());
        }
    }
    
    public void add(mm_monster card){
        list.add(card);
    }
    
    public void add(int position, mm_monster card){
        list.add(position, card);
    }
    
    public void remove(mm_monster card){
        list.remove(card);
    }
    
    public void remove(int position){
        list.remove(position);
    }
    
    public mm_monster get(int target){
        return list.get(target);
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
