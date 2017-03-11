/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.cards.mm_monsters;

/**
 *
 * @author brnpham
 */
public class mm_monster_template extends mm_monster{
//Constructor
//Health, Attack, Defense, Summontime, Value, Limit, Name
    public mm_monster_template(){
        super(0, 0, 0, 0, 0, 0, "template");
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
