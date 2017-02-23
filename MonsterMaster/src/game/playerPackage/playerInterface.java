/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.playerPackage;

import game.strategy.*;

/**
 *
 * @author brnpham
 */
public interface playerInterface {
    public void defaultDeck();
    public int[] countHand();
    public void getCard();
    public void setHp(int dmg);
    public int getHp();
    public boolean canAttack();
    public boolean getLose();
    public void setStrategy(Strategy strat);
    
    //public attack(int position, int target);
    //public bool canAttack ();
    //public int countHand ();
    //public bool draw();
    //public void discard (int card);
    //public void endTurn();
    //public void playCard(int position);
    //public void printHand();
    
    
}
