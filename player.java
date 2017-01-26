package game;
import cards.*;

import java.util.ArrayList;
import java.util.Arrays;

//This class will represent the players of the game.
//The class holds their deck, hand, graveyard, and active monsters.
//The class also holds how much life they have and the flag for when they lose.
public class player {
	
	//int value that represents how much life the player has 
	//in game. When this goes to 0 or below then player loses.
	private int health = 20;
	
	
	//Variable that holds all the cards in the players deck.
	//Will be used to add cards to hand or summon skeletons through spell.
	public deck Deck;
	
	
	//Variable that holds all cards in player's hand
	//These cards are playable by the player.
	public ArrayList <Card> hand = new ArrayList <Card>();
	
	
	//Variable that holds all used up spells or killed monsters.
	//These cards will remain here unless beckon or necromancy spell is used.
	public ArrayList <Card> grave = new ArrayList <Card>();
	
	
	//Variable that holds the monsters that protects the player.
	//These monsters can attack the enemy if the attacking monster's
	//cooldown is 0.
	public ArrayList <Monster> field = new ArrayList <Monster>();
	
	
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
	
	
	//A private variable that will be used to use the functions
	//in move class. Used attack method.
	private move action = new move();
	
	
	//A simple string that holds the name of the player.
	//Only used in tester for display purposes while output
	//runs to see what is happening. 
	public String id;
	
	
	public boolean summoned = false;
	
	//creates premade deck then sends it to deck class to shuffle 
	//premade deck is then stored into Deck variable.
	//Constructor also sets the strategy the player will use.
	//Name of player is assigned in this function.
	//Function will draw the player 4 cards to start.
	public player(Dumb strat,Offensive plan,String name){
		ArrayList <Card> Cards = new ArrayList <Card>();
		Monsters group = new Monsters();
		Spells powers = new Spells();
		Cards.add(group.alien);
		Cards.add(group.alien);
		Cards.add(group.knight);
		Cards.add(group.knight);
		Cards.add(group.golem);
		Cards.add(group.golem);
		Cards.add(group.skeleton);
		Cards.add(group.skeleton);
		Cards.add(group.skeleton);
		Cards.add(group.vampire);
		Cards.add(group.vampire);
		Cards.add(group.vampire);
		Cards.add(group.dwarf);
		Cards.add(group.dwarf);
		Cards.add(group.dwarf);
		Cards.add(group.greebler);
		Cards.add(group.greebler);
		Cards.add(group.greebler);
		Cards.add(powers.shield);
		Cards.add(powers.shield);
		Cards.add(powers.sword);
		Cards.add(powers.sword);
		Cards.add(powers.sword);
		Cards.add(powers.curse);
		Cards.add(powers.curse);
		Cards.add(powers.curse);
		Deck = new deck(Cards);
		id = name;
		planA = strat;
		planB = plan;
		for(int loop = 0;loop < 5;loop++){
			getCard();
		}
	}
	
	
	//Player draws a card from their deck.
	//If they can't then they lost.
	//Programs if they can draw before getting card from deck.
	public void getCard(){
		if(Deck.checkDeck()){
			hand.add(Deck.draw());
		}
		else{
			lose = true;}
		
	}
	
	
	//Function that changes player's health value.
	//For now will only decrease from monster attack.
	//If the health value goes below 0 or equal to 0 then 
	//flag for player lost is true.
	public void setHp(int dmg){
		health -= dmg;
		if (health <= 0){lose = true;}
	}
	
	
	//Gets the health value for player.
	//Used for displaying player's life.
	public int getHp(){ return health;}
	
	
	//This functions checks if the player's hand has at least
	//one monster. Returns true or false depending if there is
	//a monster in the hand or not.
	public boolean hasHandMonster(){
		for (int loop = 0; loop < hand.size();loop++){
			if(hand.get(loop).getType() == "monster"){
				return true;
			}
		}
		return false;
	}
	
	
	
	public boolean[][] spellUse(){
		boolean[][] spells = new boolean[3][2];
		Arrays.fill(spells[0], false);
		Arrays.fill(spells[1], false);
		Arrays.fill(spells[2], false);
		for (int loop = 0; loop < hand.size();loop++){
			if(hand.get(loop).getName() == "sword"){
				spells[0][0] = true;
				break;
			}
		}
		for (int loop = 0; loop < hand.size();loop++){
			if(hand.get(loop).getName() == "shield"){
				spells[1][0] = true;
				break;
			}
		}
		for (int loop = 0; loop < hand.size();loop++){
			if(hand.get(loop).getName() == "curse"){
				spells[2][0] = true;
				break;
			}
		}
		
		for (int loop = 0; loop < field.size();loop++){
			if(!field.get(loop).sword){
				spells[0][1] = true;
				break;
			}
		}
		for (int loop = 0; loop < field.size();loop++){
			if(!field.get(loop).shield){
				spells[1][1] = true;
				break;
			}
		}
		for (int loop = 0; loop < field.size();loop++){
			if(!field.get(loop).curse){
				spells[2][1] = true;
				break;
			}
		}
		return spells;
	}
	
	
	public boolean canAttack(){
		for(int loop = 0; loop < field.size();loop++){
			if(!field.get(loop).attacked && field.get(loop).getPlaced() <= 0){
				return true;
			}
		}
		return false;
	}
	
	
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
		move choice = new move();
		boolean hard = false;
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
		
		getCard();
		if(lose){return;}
		while(!choice.pass && !enemy.lose){
			if(planA != null){
				choice = planA.pickMove(this, enemy.field);
			}
			else { 
				choice = planB.pickMove(this, enemy.field);}
			if(choice.summonAtk){
				choice.summonStrongest(this);
				summoned = true;
			}
			if(choice.summonDef){
				choice.summonDefensive(this);
				summoned = true;
			}
			if(choice.summon){
				choice.summon(this);
				summoned = true;
			}
			if(choice.buffAtk){
				choice.aBuff(this);
			}
			if(choice.buffDef){
				choice.dBuff(this);
			}
			if(choice.curse){
				choice.debuffMon(this, enemy.field);
			}
			if(choice.attack){
				if(planB != null){hard = true;}
				choice.battle(this, enemy,hard);
			}
		}
		refresh();
	}
	
	

}
