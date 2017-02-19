/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.YugiMonsters;

import cards.Card;
import cards.Monster;
import cards.YugiSpells.Magic;
import game.playerPackage.YugiPlayer;


/**
 * This is the parent monster card for Yugioh.
 * @author Michael
 * @version 1.1
 */
public class Mon extends Monster implements Card{

    
    
    //This is the level of the monster. This ranges from 1-12.
    //Levels 1-4 don't require a sacrifice.
    //Levels 5-6 require the player to sacrifice 1 of their monsters on the 
    //           field to summon.
    //Levels 7-8 requires 2 monsters as sacrifice.
    //Levels 9-12 requires 3 monsters as sacrifice.
    private int level;

    
    
    //These are the modifiers of the attack and defense values of the monster.
    //These are increased or decreased by monster effects or magic cards.
    public int atkMod;
    public int defMod;
    
    
    
    //This is an array of the category that the monster belongs to.
    //These include: normal,fusion,ritual,effect,token,synchro,xyz,toon,union,
    //               gemini,spirit,pendulum, and tuner.
    //But for build 1.0 only normal or effect are used.
    //At most only 2-3 are on any monster.
    // n = normal   y = synchro      s = spirit     p = pendulum
    // e = effect   x = xyz          t = tuner
    // r = ritual   u = union        k = token
    // f = fusion   g = gemini       c = toon
    private String category;
    
    
    
    // This is the family the monster belongs too. Each monster belongs to only
    // 1 of these numbers. 
    // 0 = Aqua              9 = Machine           18 = Warrior
    // 1 = Beast            10 = Plant             19 = Winged Beast
    // 2 = Beast Warrior    11 = Psychic           20 = Zombie
    // 3 = Dinosaur         12 = Pyro
    // 4 = Dragon           13 = Reptile
    // 5 = Fairy            14 = Rock 
    // 6 = Fish             15 = Sea Serpent 
    // 7 = Fiend            16 = Spellcaster
    // 8 = Insect           17 = Thunder
    private int family;
    
    
    
    //Here is the element that the monster is.
    //A monster is one of these elements. Use the corresponding number for
    //the right element.
    // 0 = Dark     3 = Light
    // 1 = Earth    4 = Water
    // 2 = Fire     5 = Wind
    private int element;
    
    
    
    //Flag that tells if the card is in face down or face position.
    //True = face up        False = face down
    public boolean flipped;
    
    
    
    //This is the flag that says if the monster is in attack position or defense.
    public boolean attackPos;
    
    
    
    //Here is a boolean array that holds flags that tell that the monster
    //is equipped with a spell card in both fields.
    //Mainly used to remove spell cards equipped to a monster when it dies.
    //Areas [0-4] = Owner's spell/trap card zone
    //Areas [5-9] = Enemy's spell/trap card zone
    public boolean[] equipped = new boolean[10];
    
    
    
    //Id is name of the monster.
    //Lvl is the level of the monster.
    //The base attack points and defense points of the monster ranges from 0-5000.
    //Types is a string that holds the characters that symbolizes the category
    //the monster belongs to.
    //Fam holds the int value which says family monster belongs to.
    //Ele holds the int value which says element monster belongs to.
    public Mon(String id, int lvl, int atk, int def,String types, int fam,int ele){
        super(id,atk,def,0,0);
        level = lvl;
        category = types;
        family = fam;
        element = ele;
    }

    @Override
    public String getType() {
         return "monster";
    }

    @Override
    public String getName() {
        return name;
    }

    
    
    //Here is the function where the monster attacks.
    //If the monster's target is -1 then it attacks the opposing player.
    //If not then the monster attacks the opposing player's monster at the 
    //corresponding target area.
    //Inside are the outcomes of the battle between the monsters. 
    public void attack(YugiPlayer owner, YugiPlayer enemy, int target, int position) {
        Mon opponent = enemy.field.getMon(target);
        switch(target){
            case -1:
                enemy.setHp(getAtk()); break;
            case -2: return;
            default:
            if(attack > opponent.getStat()){
                if(opponent.attackPos){
                    enemy.setHp(attack - opponent.getStat());
                    opponent.deathEffect(owner, enemy, target);
                    enemy.grave.add(opponent);
                    enemy.field.removeMon(target);
                }
                else {
                    opponent.deathEffect(owner, enemy, position);
                    enemy.grave.add(opponent);
                    enemy.field.removeMon(target);
                }
            }
            else if(attack < opponent.getStat()){
                    if(opponent.attackPos){
                        owner.setHp(opponent.getStat()-attack);
                        owner.field.getMon(position).deathEffect(owner, enemy, position);
                        owner.grave.add(owner.field.getMon(position));
                        owner.field.removeMon(position);
                    }
                else {
                    owner.setHp(opponent.getStat()-attack);
                    opponent.flipped = true;
                    }
            }
            else {
                if(opponent.attackPos){
                    opponent.deathEffect(owner, enemy, target);
                    enemy.grave.add(opponent);
                    enemy.field.removeMon(target);
                    owner.field.getMon(position).deathEffect(owner, enemy, position);
                    owner.grave.add(owner.field.getMon(position));
                    owner.field.removeMon(position);
                }else
                    opponent.flipped = true;
            }
        }
    }
            
            
            

    public void effect(YugiPlayer owner, YugiPlayer enemy, int target, int position) {
        //Does nothing in this class
    }
    
    
    

    /**
     * This is the function that activates an effect if it works on death and
     * removes equipped spell cards.
     * @param owner The owner of the monster.
     * @param enemy The opposing player.
     * @param position Position of the monster on the owner's field.
     */
    public void deathEffect(YugiPlayer owner, YugiPlayer enemy, int position){
        int offset = 0;
        for(int loop = 0; loop < 5;loop++){
            if(equipped[loop]){
                Magic spell = owner.field.getMagic(loop - offset);
                spell.removedEffect(owner, enemy, position, loop-offset);
                offset++;
            }
        }
        offset = 5;
        for(int loop = 5; loop < 10;loop++){
            if(equipped[loop]){
                Magic spell = enemy.field.getMagic(loop - offset);
                spell.removedEffect(enemy, owner, position, loop-offset);
                offset++;
            }
        }
    } 
    
    
    
    //This is where the monster is added to the field.
    //Sacrificing monsters does not happen here.
    //Owner = player object that is summoning monster.
    //Position is where the monster card is in the hand.
    //State is wheter or not the monster is summoned in attack position.
    public void summon(YugiPlayer owner,boolean state){
        owner.field.addMon(this);
        owner.hand.remove(this);
        if(state){ 
            attackPos = true;
            flipped = true;
        }
        else{
            attackPos = false;
            flipped = false;
        }
    }
    
    
    
    //A simple function that gets either the attack value or defense value
    //of the monster based on its position. This is used in battle calculations.
    public int getStat(){
        if(attackPos){return getAtk();}
        else return getDef();
    }
    
    
    
    //Setter and getters of the different attributes of the monster.
    @Override
    public int getAtk(){
        if(attack + atkMod < 0)
            return 0;
        else
            return attack + atkMod;
    }
    
    
    
    @Override
    public int getDef(){
    if(defense + defMod < 0)
            return 0;
        else
            return defense + defMod;
    }
    
    
    
    public String getCategory(){return category;}
    
    
    
    public void setFam(int fam){family = fam;}
    public int getFam(){return family;}
    
    
    
    public void setEle(int ele){element = ele;}
    public int getEle(){return element;}
    
    
    
    public int getLvl(){return level;}
}
