/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.cards;

/**
 * Card Properties:
 *  Name:           // Name of card
 *  Type:           // Type of card
 * @author brnpham
 */
public interface card_interface {
    //Returns the name of the card
    public String getName();
    
    //Returns the type of the card: Spell or Monster
    public String getType();
    
}
