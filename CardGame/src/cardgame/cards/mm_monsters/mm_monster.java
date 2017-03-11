/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.cards.mm_monsters;
import cardgame.monster_master.mm_card;
import cardgame.cards.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Card Properties:
 * Name: Inherited      //Name of monster
 * Type: Inherited      //Type of card (monster or spell)
 * Value: Inherited     //Value of monster (for deck building)
 * Limit: Inherited     //Limit allowed in deck
 * Health:              //Current health of Monster
 * DefaultHealth:       //Default health of Monster
 * Attack:              //Current attack of Monster
 * DefaultAttack:       //Default attack of Monster
 * Defense:             //Current defense of Monster
 * DefaultDefense:      //Default defense of Monster
 * SummonTime:          //Amount of time it takes to summon
 * Effect (Method):     //Special Effect of Monster
 * @author brnpham
 */
public abstract class mm_monster extends mm_card implements mm_monster_interface{
    //Health a monster has
    //Default is the starting and max health a monster can have
    //Mod is the modifier that comes from equipment
    protected int health, defaultHealth;
    
    //Attack a monster has
    //Default is the starting attack
    //Mod is the modifier that comes from equipment
    protected int attack, defaultAttack, posAttackMod = 0, negAttackMod = 0;
    
    //Defense a monster has
    //Default is the starting defense
    //Mod is the modifier that comes from equipment
    protected int defense, defaultDefense, posDefenseMod = 0, negDefenseMod = 0;
    
    //Time it takes to summon the monster
    //Current is the number of turns left to summon
    protected int summonTime;
    
    //Flag that tells if the monster is done summoning and if it can attack
    protected boolean active = false;
    
    //Trackers for status effects
    protected int poison = 0;
    protected boolean stun = false;
    
    //Flag that determines whether monster is alive or not
    protected boolean alive = true;
    
    public mm_monster(int defaultHealth, int defaultAttack, int defaultDefense, int summonTime, int value, int limit, String name) {
        super(value, limit, name, "Monster");
        this.defaultHealth = defaultHealth;
        this.defaultAttack = defaultAttack;
        this.defaultDefense = defaultDefense;
        this.summonTime = summonTime;
        
        this.health = defaultHealth;
        this.attack = defaultAttack;
        this.defense = defaultDefense;
    }
    
  //Abstract Methods
    //Attack Effect activates upon attacking
    //Defined specifically for each monster class that have an effect
    public abstract String damageEffect(mm_monster target);
    
    //Defense Effect prevents certain status effects
    //Defined specifically for each monster class
    public abstract boolean defenseEffect(String effect);
    
    //Direct Effect activates upon attacking directly
    //Defined specifically for each monster class
    public abstract boolean directEffect();
    
    
//Game Methods
    //Take damage
    public void takeDmg(int amount){
        this.health -= amount;
        if(this.health <= 0){
            death();
        }
    }
    
    //Take damage with an effect
    public void takeDmg(int amount, String effect){
        if(defenseEffect(effect)){
            return;
        } else {
            this.takeDmg(amount);
        }
                
    }
    
    //Recover an amount
    public void recoverDmg(int amount){
        if((this.health + amount) > this.defaultHealth){
            this.health = this.defaultHealth;
        } else {
            this.health += amount;
        }
    }

    //Modifies current attack, positive increases, negative decreases
    public void modAttack(int amount){
        this.attack += amount;
    }
    
    //Modifies current defense, positive increases, negative decreases
    public void modDefense(int amount){
        this.defense += amount;
    }
    
    //Decrements summon time
    public void decSummonTime(){
        if(this.summonTime > 0){
            this.summonTime--;
        }
        if(this.summonTime <= 0){
           this.active = true;
        }
    }
    
    //Death
    public void death(){
        System.out.println(this.getName() + "has died");
        this.alive = false;
    }
    
    //Effect manager
    //Manages all effects that can affect a monster
    public void effectManager(String effect, int amount){
        switch(effect){
            case "Poison":
                this.poison += amount;
                break;
            case "Psychic":
                
                break;
            case "Lower Attack":
                
                break;
            case "Stun":
                
                break;
            default:
                
        }
    }
    
    //Checks whether monster is active (finished summoning or not stunned)
    public boolean isActive(){
        return this.active;
    }
    
    //Sets a monster to active (allow monster to attack after each turn)
    public void setActive(){
        if(this.summonTime <= 0){
            this.active = true;
        }
    }
    
//Getters and Setters
    //Returns current health
    public int getHealth() {
        return health;
    }

    //Sets current health
    public void setHealth(int health) {
        this.health = health;
        if(this.health <= 0){
            death();
        }
    }

    //Returns attack + attack modifier
    public int getAttack() {
        return attack + posAttackMod - negAttackMod;
    }

    //Sets current attack
    public void setAttack(int attack) {
        this.attack = attack;
    }
    
    //Gets attack modifier (for buffs)
    public int getPosAttackMod(){
        return this.posAttackMod;
    }
    
    //Sets attack modifier (for buffs)
    public void setAttackMod(int modifier){
        this.posAttackMod = modifier;
    }

    //Returns defense + defense modifier
    public int getDefense() {
        return defense + posDefenseMod - negDefenseMod;
    }

    //Sets current defense
    public void setDefense(int defense) {
        this.defense = defense;
    }
    
    //Gets defense modifier (for buffs)
    public int getDefenseMod(){
        return this.posDefenseMod;
    }
    
    //Sets defense modifier (for buffs)
    public void setDefenseMod(int modifier){
        this.posDefenseMod = modifier;
    }

    //Returns current time to summon
    public int getSummonTime() {
        return summonTime;
    }

    //Sets time to summon
    public void setSummonTime(int summonTime) {
        this.summonTime = summonTime;
        if(this.summonTime <= 0){
            active = true;
        } else if (this.summonTime > 0){
            active = false;
        }
    }

}
