/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.cards.mm_monsters;

/**
 * Dwarf
 * Effect: None
 * Class that represents the Dwarf monster Card.
 * Strategy pattern was used in making this as it fit the best with 
 * existing code more than Observer or Decorator.
 * This card part of the homework assignment 1 and is changed to fit assignment
 * 2.
 * @author Michael
 */
public class Dwarf extends mm_monster{
//Constructor
//Health, Attack, Defense, Summontime, Value, Limit, Name
    public Dwarf(){
        super(5, 5, 5, 2, 50, 3, "Dwarf");
    }
    
//Abstract Methods
    //Attack Effect activates upon attacking
    //Defined specifically for each monster class that have an effect
    public String damageEffect(mm_monster target) {
        return "None";
    }
    
    //Defense Effect prevents certain status effects
    //Defined specifically for each monster class
    public boolean defenseEffect(String effect){
        return false;
    }
    
    //Direct Effect activates upon attacking directly
    //Defined specifically for each monster class
    public boolean directEffect(){
        return false;
    }
}
