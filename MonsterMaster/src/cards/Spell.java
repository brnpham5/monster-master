package cards;

import cards.Card;
import game.playerPackage.YugiPlayer;
import game.playerPackage.player;

public class Spell implements Card {
	
    
    
        //Name of the spell.
        //Used for displaying content of player's hand.
	private String name;
	
        
        
        //Defaulr constructor.
        //Only requires name of spell.
        //The effect of spell is dealt in their own class.
	public Spell(String id){
		name = id;
	}

        
        //Getters for type and name for Spell card.
	@Override
	public String getType() { return "spell";}

	@Override
	public String getName() { return name; }
	
        
        
        //This function is a place holder that does nothing.
        //Subclasses of spell will override this to fit their special needs.
        @Override
        public void effect(player owner, player enemy, int target, int position){
            System.out.println("This shouldn't do anything.");
            //This function does nothing in Spell parent class.
        }

    @Override
    public void effect(YugiPlayer owner, YugiPlayer enemy, int target, int position) {
        //does nothing
    }

}
