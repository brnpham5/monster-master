/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.YugiMonsters;

/**
 *
 * @author Dev
 */

public class AllyMind extends Mon{
    
    /*
    Monster Ally Mind
    Description: 
    A high-performance unit developed to enhance the Artificial Intelligence program 
    in Ally of Justice. Loaded with elements collected from a meteor from the Worm Nebula, 
    it allows for high tuning performance, but its true capacity is not yet uncovered.
    
    */
    
    
    //Id is name of the monster.
    //Lvl is the level of the monster.
    //The base attack points and defense points of the monster ranges from 0-5000.
    //Types is a string that holds the characters that symbolizes the category
    //the monster belongs to.
    //Fam holds the int value which says family monster belongs to.
    //Ele holds the int value which says element monster belongs to.
    // ( String id, int lvl, int atk, int def,String types, int fam,int ele )
    public AllyMind(){
        super("Ally Mind",5,1800,1400,"n",9,0);
    }
}