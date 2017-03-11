/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.cards.mm_monsters;

import cardgame.monster_master.mm_card_interface;

/**
 * Card Properties:
 * Name:                //Inherited
 * Type:                //Inherited
 * Health:              //Current health of Monster
 * DefaultHealth:       //Default health of Monster
 * Attack:              //Current attack of Monster
 * DefaultAttack:       //Default attack of Monster
 * Defense:             //Current defense of Monster
 * DefaultDefense:      //Default defense of Monster
 * SummonTime:          //Amount of time it takes to summon
 * Effect:              //Special Effect of Monster
 * @author brnpham
 */
public interface mm_monster_interface extends mm_card_interface{
//Game Methods
    //Take damage
    public void takeDmg(int amount);
    
    //Take damage with an effect
    public void takeDmg(int amount, String effect);
    
    //Recover damage
    public void recoverDmg(int amount);

    //Returns current health
    public int getHealth();
    
    //Sets current health to new amount
    public void setHealth(int newHealth);
    
    //Returns current attack
    public int getAttack();
    
    //Sets current attack
    public void setAttack(int newAttack);
    
    //Modify current attack
    public void modAttack(int amount);
    
    //Returns current defense
    public int getDefense();
    
    //Sets current defense
    public void setDefense(int newAttack);
    
    //Modify current defense
    public void modDefense(int amount);
    
    //Get summon time
    public int getSummonTime();
    
    //Decrement summon time
    public void decSummonTime();
}

