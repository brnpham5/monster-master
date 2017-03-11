/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.cards.mm_monsters;

/**
 * Robot
 * Effect: Immune to heal, poison, and psychic
 * @author brnpham
 */
public class Robot extends mm_monster{
//Constructor
//Health, Attack, Defense, Summontime, Value, Limit, Name
    public Robot(){
        super(5, 6, 5, 2, 70, 2, "Robot");
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
        if(effect.equals("Poison") || effect.equals("Psychic")){
            return true;
        }
        return false;
    }
    
    //Direct Effect activates upon attacking directly
    //Defined specifically for each monster class
    public boolean directEffect(){
        return false;
    }
    
    //Robot can not be healed
    @Override
    public void recoverDmg(int amount){
        return;
    }
}
