/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.playerPackage;

import cards.YugiMonsters.Mon;
import cards.YugiSpells.Magic;
import java.util.ArrayList;

/**
 * This class holds the 2 fields that a Yugioh player will have.
 * Included are functions to manipulate the fields and functions to help the
 * strategy.
 * @author Michael
 */
public class YugiPlayerField{
    /**
     * The part of the field that holds the monster cards.
     */
     public ArrayList <Mon> monsters = new ArrayList();
     
     
     
     /**
      * The part of the field that holds the magic cards.
      */
     public ArrayList <Magic> magics = new ArrayList();
     
     
     
     /**
      * The maximum number of cards that can be on side of the field.
      */
     public final int MAXSIZE = 5; 
     
     
    /**
     * Returns a list of monsters on the field
     * @return An arrayList of monsters the player has on the field 
     */
     public ArrayList <Mon> getMonsters(){
        return monsters;
    }
     
     
    
    /**
     * Returns a list of spells on the field
     * @return An arrayList of spells the player has on the field 
     */ 
    public ArrayList <Magic> getSpells(){
        return magics;
    }
    
    
    
    /**
     * Tries to find a monster card in the player's field and remove it. 
     * @param card The monster card the function is trying to find on the field.
     * @return An arrayList of spells the player has on the field 
     */ 
    public Mon getMon(Mon card){
        if(monsters.contains(card)){
            Mon temp = monsters.get(monsters.indexOf(card));
            monsters.remove(card);
            return temp;
            
        } else {
            System.out.println ("Card not found.");
            return null;
        }
    }
    
    
    
    /**
     * Tries to find a magic card in the player's field and remove it. 
     * @param card The monster card the function is trying to find on the field.
     * @return An arrayList of spells the player has on the field 
     */ 
    public Magic getSpell(Magic card){
        if(magics.contains(card)){
            Magic temp = magics.get(magics.indexOf(card));
            magics.remove(card);
            return temp;
            
        } else {
            System.out.println ("Card not found.");
            return null;
        }
    }
    
    
    
    /**
     * Prints out the entire player field
     */
    public void print(){
        System.out.println("Monster:");
        for(Mon card : monsters){
            if(card.flipped){
                if(card.attackPos)
                    System.out.println ("{"+card.getName()+"}");
                else
                    System.out.println ("["+card.getName()+"]");
            }else
               System.out.println ("("+card.getName()+")"); 
            
        }
        System.out.println("\nSpells:");
        for(Magic card : magics){
               System.out.println (card.getName());    
        }
        System.out.print("\n");
    }
    
    
    
    /**
     * Adds a monster card to the field if the field is not at max size.
     * @param card The monster card that will be added to the field.
     */
    public void addMon(Mon card){
        if(monsters.size() < MAXSIZE)
            monsters.add(card);
    }
    
    
    
   /**
     * Adds a magic card to the field if the field is not at max size.
     * @param card The monster card that will be added to the field.
     */
    public void addMagic(Magic card){
        if(magics.size() < MAXSIZE)
            magics.add(card);
    }
    
    
    
    /**
     * Removes the first instance of the selected monster card.
     * @param card The monster card that will be removed
     */
    public void removeMon(Mon card){
        monsters.remove(card);
    }
    
    
    
    /**
     * Removes the first instance of the selected magic card.
     * @param card The magic card that will be removed
     */
    public void removeMagic(Magic card){
        magics.remove(card);
    }
    
    
    
    /**
     * Removes the card at the selected position.
     * @param position Position of of the monster card to be removed
     */
    public void removeMon(int position){
        if(position < monsters.size() && position > -1)
            monsters.remove(position);
    }
    
    
    
    /**
     * Removes the card at the selected position.
     * @param position Position of of the magic card to be removed
     */
    public void removeMagic(int position){
        if(position < magics.size() && position > -1)
            magics.remove(position);
    }
    
    
    
    /**
     * Gets the monster card at the selected position.
     * @param target the position of the card that will be returned
     * @return the card that was at the selected position
     */
    public Mon getMon(int target){
        if(target < monsters.size() && target > -1)
            return monsters.get(target);
        else
            return null;
    }
    
    
    
    /**
     * Gets the magic card at the selected position.
     * @param target the position of the card that will be returned
     * @return the card that was at the selected position
     */
    public Magic getMagic(int target){
        if(target < magics.size() && target > -1)
            return magics.get(target);
        else
            return null;
    }
    
    
    
    /**
     * Searches the monster field and check if there is a monster with selected
     * element.
     * @param element The int value that represents the wanted element.
     * @return A boolean that says a monster of that element exists.
     */
    public boolean findElement(int element){
        for(Mon card : monsters){
            if(card.getEle() == element)
                return true;
        }
        return false;
    }
    
    
    
   /**
     * Searches the monster field and check if there is a monster with selected
     * family.
     * @param family The int value that represents the wanted family
     * @return A boolean that says a monster of that family exists.
     */
    public boolean findFamily(int family){
        for(Mon card : monsters){
            if(card.getFam() == family)
                return true;
        }
        return false;
    }
    
    
    
    /**
     * Gives size of monster field
     * @return The size of the player's monster field.
     */
    public int monSize(){
        return monsters.size();
    }
    
    
    
    /**
     * Gives size of spell field
     * @return The size of the player's spell field.
     */
    public int magicSize(){
        return magics.size();
    }
    
    
    
    /**
     * Returns the answer if the spell field is empty.
     * @return A boolean that tells if spell field is empty
     */
    public boolean isMagicEmpty(){
        return magics.isEmpty();
    }
    
    
    
    /**
     * Returns the answer if the monster field is empty.
     * @return A boolean that tells if monster field is empty
     */
    public boolean isMonEmpty(){
        return monsters.isEmpty();
    }
    
    
    
    /**
     * Clears the monster field.
     */
    public void MonsterClear(){
        monsters.clear();
    }
    
    
    
    /**
     * Clears the spell field.
     */
    public void MagicClear(){
        magics.clear();
    }
}
