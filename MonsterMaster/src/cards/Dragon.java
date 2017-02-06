/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

/**
 * Class that represents the Dragon monster Card.
 * Strategy pattern was used in making this as it fit the best with 
 * existing code more than Observer or Decorator.
 * @author Michael
 */
public class Dragon extends Monster{
    public Dragon(){
        super("dragon",8,4,3,6);
    }
}
