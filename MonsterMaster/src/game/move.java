package game;

//Here is the move interface where you can can create various moves that the

import game.playerPackage.YugiPlayer;
import game.playerPackage.player;

//AI can make. You will need to fill in the execute function when implementing
//this class. Other functions can be created to help those classes that 
//implemented this.
public interface move {
	
    
   
    //This is the function to call to use the different types of moves.
    //Classes that implement the move class will need to edit this function
    //to fit their needs. They will need to use the 2 player objects to do their
    //moves.
    public void execute(player user, player enemy);

    
    
    public void executeY(YugiPlayer user,YugiPlayer enemy);
}