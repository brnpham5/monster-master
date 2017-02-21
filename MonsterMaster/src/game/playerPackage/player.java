package game.playerPackage;
import game.strategy.Dumb;
import game.strategy.Offensive;
import cards.Spells;
import cards.Monsters;
import cards.Monster;
import cards.*;
import game.move;

import java.util.ArrayList;

//This class will represent the players of the game.
//The class holds their deck, hand, graveyard, and active monsters.
//The class also holds how much life they have and the flag for when they lose.
public class player implements playerInterface{
	
	//int value that represents how much life the player has 
	//in game. When this goes to 0 or below then player loses.
	private int health = 20;
	
	
	//Variable that holds all the cards in the players deck.
	//Will be used to add cards to hand or summon skeletons through spell.
        public playerDeck Deck = new playerDeck();
	
	
	//Variable that holds all cards in player's hand
	//These cards are playable by the player.
        public playerHand hand = new playerHand();
	
	
	//Variable that holds all used up spells or killed monsters.
	//These cards will remain here unless beckon or necromancy spell is used.
	public playerGrave grave = new playerGrave();
	
	//Variable that holds the monsters that protects the player.
	//These monsters can attack the enemy if the attacking monster's
	//cooldown is 0.
	public playerField field = new playerField();
	
	//Variable is flag that tells if the player has lost or not.
	//Will only switch to true if the player can't draw or lost
	//all of their health points.
	public boolean lose = false;
	
	
	//Variable that determines if the dumb strategy will be used
	//by the player. This strategy can only be used by player if 
	//user choses n at starting prompt.
	public Dumb planA = null;
	
	
	//Same thing as planA but for the offensive strategy. This 
	//strategy is used by the computer and user if they choose
	//y at starting prompt.
	public Offensive planB = null;
	
        
	
	//A simple string that holds the name of the player.
	//Only used in tester for display purposes while output
	//runs to see what is happening. 
	public String id;
	
	
        
        //Flag that tells that the player has summoned a monster.
        //This will be turned true after executing a summoning move.
        //The flag is turned false at the end of the player's turn.
	public boolean summoned = false;
	
        public player(){
            defaultDeck();
            id = "Default";
            for(int loop = 0;loop < 5;loop++){
		getCard();
            }
            
        }
        
	//creates premade deck then sends it to deck class to shuffle 
	//premade deck is then stored into Deck variable.
	//Constructor also sets the strategy the player will use.
	//Name of player is assigned in this function.
	//Function will draw the player 4 cards to start.
	public player(Dumb strat,Offensive plan,String name){
		
		defaultDeck();
		id = name;
		planA = strat;
		planB = plan;
		for(int loop = 0;loop < 5;loop++){
			getCard();
		}
	}
	
        
        //Constructor that you can use for testing.
        //Set the strategy for the player with Dumb strat or Offensive plan.
        //Only one strategy should be have a value and the other is null.
        //If both parameters have values, strat is used in move planning.
        //String name is name of player. Used for showing game details.
        //The ArrayList is the premade deck passed.
        //Draws is the numbers of draws the player does to get their hand.
        public player(Dumb strat,Offensive plan,String name,ArrayList<Card> Cards,int draws){
            Deck = new playerDeck(Cards);
            id = name;
            planA = strat;
            planB = plan;
            for(int loop = 0;loop < draws;loop++){
		getCard();
            }
        }
        
        
        //Moved the deck creation from constructor to this function.
        //By editing this function you create the default deck that player
        //objects use.
        public void defaultDeck(){
            ArrayList <Card> Cards = new ArrayList <Card>();
            Monsters group = new Monsters();
		Spells powers = new Spells();
                Cards.add(group.alien());
		Cards.add(group.alien());
		Cards.add(group.knight());
		Cards.add(group.knight());
		Cards.add(group.golem());
		Cards.add(group.golem());
		Cards.add(group.skeleton());
		Cards.add(group.skeleton());
		Cards.add(group.vampire());
		Cards.add(group.vampire());
		Cards.add(group.dwarf());
		Cards.add(group.dwarf());
		Cards.add(group.greebler());
                Cards.add(group.greebler());
		Cards.add(powers.shield);
		Cards.add(powers.shield);
		Cards.add(powers.sword);
		Cards.add(powers.sword);
		Cards.add(powers.sword);
                Cards.add(powers.fireSword);
                Cards.add(powers.iceShield);
		Cards.add(powers.curse);
		Cards.add(powers.curse);
		Cards.add(powers.curse);
		Deck = new playerDeck(Cards);
        }
        
        //Counts the up number of certain cards in the hand.
        //Used by Strategy classes to add moves to arraylist for player to do.
        public int[] countHand(){
            int [] contents = new int[15];
            for(int loop = 0; loop < hand.size(); loop++){
                String spellName = hand.get(loop).getName();
                switch (spellName){
                    case "sword": contents[1]++;
                        break;
                    case "shield": contents[2]++;
                        break;
                    case "ice shield": contents[3]++;
                        break;
                    case "fire sword": contents[4]++;
                        break;
                    case "curse": contents[5]++;
                        break;
                    case "heal": contents[6]++;
                        break;
                    case "restore": contents[7]++;
                        break;
                    case "sacrifice": contents[8]++;
                        break;
                    case "doom": contents[9]++;
                        break;
                    case "forget": contents[10]++;
                        break;
                    case "gift": contents[11]++;
                        break;
                    case "fireball": contents[12]++;
                        break;
                    case "lightning": contents[13]++;
                        break;
                    case "strip": contents[14]++;
                        break;
                    default:contents[0]++;    
                }
            }
            return contents;
        }
	
	//Player draws a card from their deck.
	//If they can't then they lost.
	//Program  checks if they can draw before getting card from deck.
	public void getCard(){
		if(Deck.checkDeck()){
			hand.add(Deck.draw());
		}
		else{
			lose = true;}	
	}
	
	
	//Function that changes player's health value.
	//Positive numbers - damage to player.
        //Negative numbers = healing player.
        //The max health a player can have is 20. If player is healed for more
        //then player will have 20 health.
	//If the health value goes below 0 or equal to 0 then 
	//flag for player lost is true.
	public void setHp(int dmg){
            if((-dmg + health) == 20){
                health = 20;
            }
            health -= dmg;
            if (health <= 0){lose = true;}
	}
	
	
	//Gets the health value for player.
	//Used for displaying player's life.
	public int getHp(){ return health;}
	
	
        //This function checks that the player has specific spell cards in their
        //hand. If so set a flag to corresponding space in double array.
	public boolean[][] spellUse(int [] counts,player enemy){
		boolean[][] spells = new boolean[14][2];

                //Sets flag for true if certain spells in hand.
		if(counts[1] > 0){ spells[0][0] = true;} //Sword
                if(counts[2] > 0){ spells[1][0] = true;} //Shield
		if(counts[3] > 0){ spells[2][0] = true;} //ice shield
                if(counts[4] > 0){ spells[3][0] = true;} //fire sword
                if(counts[5] > 0){ spells[4][0] = true;} //curse
                if(counts[6] > 0){ spells[5][0] = true;} //heal
                if(counts[7] > 0){ spells[6][0] = true;} //restore
                if(counts[8] > 0){ spells[7][0] = true;} //sacrifice
                if(counts[9] > 0){ spells[8][0] = true;} //doom
                if(counts[10] > 0){ spells[9][0] = true;} //forget
                if(counts[11] > 0){ spells[10][0] = true;} //gift
                if(counts[12] > 0){ spells[11][0] = true;} //fireball
                if(counts[13] > 0){ spells[12][0] = true;} //lightning
                if(counts[14] > 0){ spells[13][0] = true;} //strip
                
                if(health <= 18){spells[6][1] = true;}
                if(health <= 15 && field.size() > 1){spells[7][1] = true;}
                if(Deck.deckSize() > 2){spells[10][1] = true;}
                if(enemy.hand.size() >= 2){spells[9][1] = true;}
                if(!enemy.field.isEmpty()){
                    spells[8][1] = true;
                    spells[11][1] = true;
                    spells[12][1] = true;
                }
                
		for (int loop = 0; loop < field.size();loop++){
			if(!field.get(loop).sword){spells[0][1] = true;}
                        if(!field.get(loop).shield){ spells[1][1] = true;}
                        if(!field.get(loop).firesword){spells[3][1] = true;}
                        if(!field.get(loop).iceshield){spells[2][1] = true;}
                        if(field.get(loop).getHp() <= field.get(loop).maxhp-2)
                        {spells[5][1] = true;}
                        if(field.get(loop).curse){spells[13][1] = true;}
		}
			
		for (int loop = 0; loop < enemy.field.size();loop++){
			if(!enemy.field.get(loop).curse){
				spells[4][1] = true;
			}
		}
                
		return spells;
	}
	
	
        //This function checks that the player has at least 1 monster on the
        //field that can attack. This function is used by the strategy classes
        //to know when to attack.
	public boolean canAttack(){
		for(int loop = 0; loop < field.size();loop++){
			if(!field.get(loop).attacked && field.get(loop).getPlaced() <= 0){
                            System.out.println(field.get(loop).getName() + " "+ field.get(loop).getPlaced());
				return true;
			}
		}
		return false;
	}
	
	
        //When player turn ends, summon flag is set to false and monster's
        //attack flag is set to false. Also every monster placed value is reduced
        //by 1.
	private void refresh(){
		summoned = false;
		for(int loop = 0; loop < field.size();loop++){
			if(field.get(loop).attacked){
				field.get(loop).attacked = false;
			}
			field.get(loop).cooloff(1);
		}
	}
	
	
	//This is how the player interacts when on their turn happens.
	//Strategy changes which actions the player does.
	//Main flow of the function is draw, summon, use spell, and attack.
	public void turn(player enemy){
		ArrayList <move> moves;
                
                //Draw Card
		getCard();
                
		System.out.print(id+" hand:");
		for (int loop = 0;loop < hand.size();loop++){
			System.out.print(hand.get(loop).getName() + ", ");
		}
		System.out.println("");
		System.out.print(id+" field:");
		for (int loop = 0;loop < field.size();loop++){
			System.out.print(field.get(loop).getName() + ", ");
		}
		System.out.println("\n");
		
                
                //If couldn't draw card, end turn to lose game.
		if(lose){return;}
		do{
			if(planA != null){
				moves = planA.pickMove(this, enemy);
			}
			else { 
				moves = planB.pickMove(this, enemy);}
			for(int loop = 0; loop < moves.size();loop++){
                            moves.get(loop).execute(this, enemy);
                        }
                if(enemy.lose){return;}
		}while(!moves.isEmpty());
		refresh();
	}
        
}
