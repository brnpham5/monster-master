/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.playerPackage;

import cards.Card;
import cards.YugiMonsters.*;
import cards.YugiSpells.*;
import game.move;
import game.strategy.YugiStrategy;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Michael
 */
public class YugiPlayer extends player{

    
    
    //int value that represents how much life the player has 
    //in game. When this goes to 0 or below then player loses.
    private int health = 4000;

	
    
    
    //Variable that holds the monsters that protects the player.
    //These monsters can attack the enemy if the attacking monster's
    //position is attack.
    public YugiPlayerField field = new YugiPlayerField();
	
    
    //Variable is flag that tells if the player has lost or not.
    //Will only switch to true if the player can't draw or lost
    //all of their health points.
    public boolean lose = false;
        
        
    
    //Variable that determines if the dumb strategy will be used
    //by the player. This strategy can only be used by player if 
    //user choses n at starting prompt.
    YugiStrategy plan;

    
    
    
    //
    public YugiPlayer(YugiStrategy strat,String name){
        super(null,null,name);
        plan = strat;
    }
    
    @Override
    public void defaultDeck() {
        ArrayList<Card> Cards = new ArrayList();
        Cards.add(new Greeble());
        Cards.add(new Greeble());
        Cards.add(new DrakeValleyMaster());
        Cards.add(new DrakeValleyMaster());
        Cards.add(new MasterNinja());
        Cards.add(new MasterAlien());
        Cards.add(new MrBones());
        Cards.add(new MrBones());
        Cards.add(new MrBones());
        Cards.add(new Fireyarou());
        Cards.add(new Fireyarou());
        Cards.add(new Hinotama());
        Cards.add(new Salamandra());
        Cards.add(new BerserkerSword());
        Cards.add(new NephthysCurse());
        Cards.add(new SoulShield());
        Cards.add(new TowerShield());
        Deck = new playerDeck(Cards);
    }

    @Override
    public int[] countHand() {
        int [] contents = new int[13];
            for(int loop = 0; loop < hand.size(); loop++){
                String spellName = hand.get(loop).getName();
                switch (spellName){
                    case "Berserker's Sword": contents[1]++;
                        break;
                    case "Tower Shield": contents[2]++;
                        break;
                    case "Soul Shield": contents[3]++;
                        break;
                    case "Salamandra": contents[4]++;
                        break;
                    case "Nephthy's Curse": contents[5]++;
                        break;
                    case "heal": contents[6]++;//Need to change
                        break;
                    case "restore": contents[6]++;//Need to change
                        break;
                    case "Hinotama": contents[7]++;
                        break;
                    case "lightning": contents[7]++;//Need to change
                        break;
                    case "sacrifice": contents[8]++;//Need to change
                        break;
                    case "doom": contents[9]++;//Need to change
                        break;
                    case "forget": contents[10]++;//Need to change
                        break;
                    case "gift": contents[11]++;//Need to change
                        break;
                    case "strip": contents[12]++;//Need to change
                        break;
                    default:contents[0]++;    
                }
            }
            return contents;
    }

    
    
    /**
     * Player draws a card from their deck; if they can't they lose.
     */
    @Override
    public void getCard() {
        if(Deck.checkDeck()){
            hand.add(Deck.draw());
	}
	else{lose = true;}	
    }

    
    
    /**
     * Increases or decreases the player's health value based on given value. 
     * @param dmg If this value is negative then player is healed. If this
     *            value is positive then player is damaged.
     */
    @Override
    public void setHp(int dmg) {
        health -= dmg;
        if (health <= 0){lose = true;}
    }

    
    
    /**
     * Returns the player's health point value
     * @return Player's health point value.
     */
    @Override
    public int getHp() {return health;}
    
    
    
    
    @Override
    public boolean[][] spellUse(int[] counts, player enemy) {
        return new boolean [1][1];}
    
    
    
    
    public boolean[][] spellUse(int[] counts, YugiPlayer enemy) {
        boolean[][] spells = new boolean[13][2];
        
        if(field.magicSize() >= field.MAXSIZE){ return spells;}
        
         //Sets flag for true if certain spells in hand.
	if(counts[1] > 0){ spells[0][0] = true;} //Sword
        if(counts[2] > 0){ spells[1][0] = true;} //Shield
	if(counts[3] > 0){ spells[2][0] = true;} //ice shield
        if(counts[4] > 0){ spells[3][0] = true;} //Salamandra
        if(counts[5] > 0){ spells[4][0] = true;} //Nephthys Curse
        if(counts[6] > 0){ //heal spells
            spells[5][0] = true;
            spells[5][1] = true;
        } 
        if(counts[7] > 0){ //damage spells
            spells[6][0] = true;
            spells[6][1] = true;
        } 
        if(counts[8] > 0){ spells[7][0] = true;} //sacrifice
        if(counts[9] > 0){ spells[8][0] = true;} //doom
        if(counts[10] > 0){ spells[9][0] = true;} //forget
        if(counts[11] > 0){ spells[10][0] = true;} //gift
        if(counts[12] > 0){ spells[13][0] = true;} //strip
        
        if(!enemy.field.isMonEmpty()){
            spells[4][1] = true;
            spells[8][1] = true;
        }
        
        if(Deck.deckSize() > 2){ spells[10][1] = true;}
        if(!enemy.hand.isEmpty()){ spells[9][1] = true;}
        if(!field.isMonEmpty()){
            spells[0][1] = true;
            spells[1][1] = true;
            spells[2][1] = true;
            if(field.findElement(2))
                spells[3][1] = true;
        }
        
        if(field.monSize() > 1){ spells[7][1] = true;}
        
        return spells;
    }

    /**
     * Checks the player field and returns a boolean if there is a monster
     * that can attack.
     * @return A boolean that says if a monster can attack.
     */
    @Override
    public boolean canAttack() {
        for(int loop = 0; loop < field.monSize();loop++){
            Mon monster = field.getMon(loop);
            if(!monster.attacked && monster.attackPos){
                return true;
            }
        }
        return false;
    }

    @Override
    public void turn(player enemy){}
    
    public void turn(YugiPlayer enemy) {
        plan.drawPhase(this);
        if(lose){return;}
        System.out.println("Hand");
        hand.print();
        System.out.println("Field");
        field.print();
        for(move action:plan.mainPhase(this, enemy)){
            action.execute(this, enemy);
        }
        plan.battlePhase(this, enemy);
        endphase();
    }


    
    //When player turn ends, summon flag is set to false and monster's
        //attack flag is set to false. Also every monster placed value is reduced
        //by 1.
	private void endphase(){
		summoned = false;
		for(int loop = 0; loop < field.monSize();loop++){
			if(field.getMon(loop).attacked){
				field.getMon(loop).attacked = false;
			}
		}
                while(hand.getSize() > 7){
                    int position = ThreadLocalRandom.current().nextInt(0, hand.getSize());
                    hand.remove(position);
                }
	}
}
