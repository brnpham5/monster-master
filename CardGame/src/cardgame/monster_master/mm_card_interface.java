/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.monster_master;

import cardgame.cards.card_interface;

/**
 * Card Properties:
 * Name:                //Inherited
 * Type:                //Inherited
 * Value:               //Value of card
 * Limit:               //Card limit allowed in deck
 * @author brnpham
 */
public interface mm_card_interface extends card_interface{
    public int getValue();
    public int getLimit();
}
