/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.playerPackage;

import cards.Monster;
import java.util.ArrayList;

/**
 *
 * @author brnpham
 */
public class playerField {
    public ArrayList <Monster> list = new ArrayList <Monster>();
    
    public ArrayList <Monster> getList(){
        return list;
    }
    
    public int getSize(){
        return list.size();
    }
            
    public Monster getCard(Monster card){
        if(list.contains(card)){
            Monster temp = list.get(list.indexOf(card));
            list.remove(card);
            return temp;
            
        } else {
            System.out.println ("Card not found.");
            return null;
        }
    }
    
    public void print(){
        for(Monster card : list){
            System.out.println (card.getName());
        }
    }
    
    public void add(Monster card){
        list.add(card);
    }
    
    public void add(int position, Monster card){
        list.add(position, card);
    }
    
    public void remove(Monster card){
        list.remove(card);
    }
    
    public void remove(int position){
        list.remove(position);
    }
    
    public Monster get(int target){
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
