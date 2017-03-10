/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Michael
 */
public class ClientImpl extends UnicastRemoteObject implements Client{
    
    /**
     * This variable keeps track of the state of the client.
     * -1 = End state
     * 0 = Starting state.
     * 1 = New Game
     * 2 = Load a Game
     */
    private int state;
    
    /**
     * This variable keeps track which game the player is playing.
     * The char - means no game.
     * The char M means Monster Master.
     * The char Y means Yugioh.
     */
    private char game;
    
    
    /**
     * Constructor for the client implementation.
     * @throws RemoteException 
     */
    public ClientImpl() throws RemoteException {
        state = 0;
        game = '-';
    }

    
    /**
     * This function takes in the the user's choice and sets the state and game
     * variables. This is called at the start of the program and is repeatedly
     * called if user enters invalid choices.
     * @param choice The user's choice from a menu in Main.
     * @return A string that tells the user what they did.
     * @throws RemoteException 
     */
    @Override
    public String chooseGame(int choice) throws RemoteException{
        String result = "";
        switch(choice){
            case 1:
                game = 'M'; 
                result = "Starting Monster Master."; break;
            case 2:
                game = 'Y'; 
                result = "Starting Yu-gi-oh."; break;
            case 3:
                state = -1;
                result = "Exiting program.";break;
        }
        return result;
    }
    
    
    /**
     * A getter for state
     * @return State variable
     */
    @Override
    public int getState(){return state;}
    
    
    /**
     * A getter for game variable
     * @return Game Variable
     */
    @Override
    public char getGame(){return game;}

    /**
     * Function used when game is finished and sets the state variable to end state.
     */
    @Override
    public void endGame(){state = -1;}
    
    /**
     * 
     * @param choice
     * @return
     * @throws RemoteException 
     */
    @Override
    public int gameMainMenu(int choice) throws RemoteException {
        switch(choice){
            case 1:
                state = 1; break;
            case 2:
                state = 2; break;
        }
                
        return state;
    }
    
    
}
