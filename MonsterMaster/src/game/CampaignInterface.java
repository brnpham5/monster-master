/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Scanner;

/**
 *
 * @author Michael
 */
public interface CampaignInterface {
    /**
     * This function will print out the main menu of the game.
     */
    public void play();
    
    
    /**
     * This function will set player object values for the match. This is selected 
     * by the player. 
     */
    public void newGame(Scanner in) throws InterruptedException;
    
    
    /**
     * This is called when the player has selected to load a previous save.
     * Save data will be loaded into player objects and match will commence.
     */
    public void loadGame();
    
    
    /**
     * 
     */
    public int battle(Scanner in) throws InterruptedException;
}
