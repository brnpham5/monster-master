package game;

import cards.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class deck {
	//The arraylist that will hold all cards that are currently in deck.
	private ArrayList <Card> Cards;
	
	//Constructor that is used for testing.
	//This will take in any set of cards.
	//It will not check the size of the arraylist.
	public deck(ArrayList <Card> premade){
		premade = shuffle(premade);
		Cards = premade;
	}
	
	
	
	//Gets the first card from the deck and returns it.
	//Removes the drawn card from deck.
	public Card draw(){
		Card one = Cards.get(0);
		Cards.remove(0);
		return one;
	}
	
	
	//Makes sure there is cards in the deck.
	//This is used to make sure the player loses to no 
	//cards drawn.
	public boolean checkDeck(){ return (Cards.size() != 0); }
	
	//Function to check the size of the deck
    //Will be used in other classes to check deck size for
    //specified size. 
    public int deckSize(){ return Cards.size(); }
	
	
	//Since premade decks will always be the same, this function
	//will make the different decks for each game. The function will 
	//take a deck then randomize the contents and return it in a 
	//different ArrayList.
	private ArrayList<Card> shuffle(ArrayList <Card> Deck){
		ArrayList <Card> pile = new ArrayList <Card>();
		int cap = Deck.size();
		for (int loop = 0; loop < cap;loop++){
			int position = ThreadLocalRandom.current().nextInt(0, Deck.size());
			pile.add(Deck.get(position));
			Deck.remove(position);
		}
		return pile;
	}
}
