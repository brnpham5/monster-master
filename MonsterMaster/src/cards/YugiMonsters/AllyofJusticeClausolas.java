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

public class AllyofJusticeClausolas extends Mon{
    
    /*
    Monster Ally of Justice Clausolas
    Description: 
    A mighty monster in Mist Valley, and the ultimate weapon designed from Claiomh Solais. 
    Its surprise attacks from above baffle invaders.
    
    */
    
    
    //Id is name of the monster.
    //Lvl is the level of the monster.
    //The base attack points and defense points of the monster ranges from 0-5000.
    //Types is a string that holds the characters that symbolizes the category
    //the monster belongs to.
    //Fam holds the int value which says family monster belongs to.
    //Ele holds the int value which says element monster belongs to.
    // ( String id, int lvl, int atk, int def,String types, int fam,int ele )
    public AllyofJusticeClausolas(){
        super("Ally of Justice Clausolas",6,2300,1200,"n",9,0);
    }
}