/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.monster_master;

import cardgame.cards.card;

/**
 * Card Properties:
 * Name:                //Inherited
 * Type:                //Inherited
 * Value:               //Value of card
 * Limit:               //Card limit allowed in deck
 * @author brnpham
 */
public class mm_card extends card {
    protected int value;
    protected int limit;

    public mm_card(int value, int limit, String name, String type) {
        super(name, type);
        this.value = value;
        this.limit = limit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
    
}
