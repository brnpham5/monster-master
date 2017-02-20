package cards;

import game.playerPackage.YugiPlayer;
import game.playerPackage.player;

//Card interface only used by all cards in the game.
public interface Card {
    
    
    
        //Funtion to get the type of the card.
	public String getType();
        
        
        
        //Function to get the name of the card.
	public String getName();
        
        
        
        //Function that works different depending on the type
        //of card. More details about this function in the
        //Monster class and the Spell class
        public void effect(player owner,player enemy,int target,int position);
        
        
        public void effect(YugiPlayer owner,YugiPlayer enemy,int target,int position);
}
