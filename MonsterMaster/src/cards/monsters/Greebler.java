/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.monsters;

import cards.Monster;

/**
 * Class that represents the Greebler monster Card.
 * Strategy pattern was used in making this as it fit the best with 
 * existing code more than Observer or Decorator.
 * This card part of the homework assignment 1 and is changed to fit assignment
 * 2.
 * @author Michael
 */
public class Greebler extends Monster{
    
    public Greebler(){
        super("greebler",4,3,1,3);
    }
}
