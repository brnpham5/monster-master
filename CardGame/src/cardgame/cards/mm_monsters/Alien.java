/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.cards.mm_monsters;

/**
 * Alien
 * Effect: Takes no damage from failed attacks
 * Class that represents the Alien monster Card.
 * Strategy pattern was used in making this as it fit the best with 
 * existing code more than Observer or Decorator.
 * This card part of the homework assignment 1 and is changed to fit assignment
 * 2.
 * @author Michael
 */
public class Alien extends mm_monster{
    
//Constructor
//Health, Attack, Defense, Summontime, Value, Limit, Name
    public Alien(){
        super(5, 5, 4, 2, 60, 3, "Alien");
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
        if(effect.equals("Failed Attack")){
            return true;
        }
        return false;
    }
    
    //Direct Effect activates upon attacking directly
    //Defined specifically for each monster class
    public boolean directEffect(){
        return false;
    }
}
