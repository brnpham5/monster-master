/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.cards.mm_monsters;

/**
 * Hydra
 * Effect: Attacks twice per turn
 * @author brnpham
 */
public class Hydra extends mm_monster{
    private boolean secondAttack = true;
//Constructor
//Health, Attack, Defense, Summontime, Value, Limit, Name
    public Hydra(){
        super(6, 6, 5, 3, 90, 2, "Hydra");
    }
    
//Abstract Methods
    //Attack Effect activates upon attacking
    //Defined specifically for each monster class that have an effect
    public String damageEffect(mm_monster target) {
        if(secondAttack == true){
            this.active = true;
            this.secondAttack = false;
        }
          
        return "None";
    }
    
    //Defense Effect prevents certain status effects
    //Defined specifically for each monster class
    public boolean defenseEffect(String effect){
        if(secondAttack == true){
            this.active = true;
            this.secondAttack = false;
        }
        return false;
    }
    
    //Direct Effect activates upon attacking directly
    //Defined specifically for each monster class
    public boolean directEffect(){
        return false;
    }
}
