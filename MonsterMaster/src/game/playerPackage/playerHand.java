/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.playerPackage;

import cards.Card;
import java.util.ArrayList;

/**
 *
 * @author brnpham
 */
public class playerHand {
    public ArrayList <Card> list = new ArrayList <Card>();
    
    public ArrayList <Card> getList(){
        return list;
    }
    
    public int getSize(){
        return list.size();
    }
            
    public Card getCard(Card card){
        if(list.contains(card)){
            Card temp = list.get(list.indexOf(card));
            list.remove(card);
            return temp;
            
        } else {
            System.out.println (card.getName()+" not found in hand.");
            return null;
        }
    }
    
    public void print(){
        for(Card card : list){
            System.out.println (card.getName());
        }
    }
    
    public void add(Card card){
        list.add(card);
    }
    
    public void add(int position, Card card){
        list.add(position, card);
    }
    
    public void remove(Card card){
        list.remove(card);
    }
    
    public void remove(int position){
        list.remove(position);
    }
    
    public Card get(int target){
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
