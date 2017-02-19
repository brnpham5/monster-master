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
    public boolean[][] spellUse(int [] counts,player enemy);
    public boolean canAttack();
    public void turn(player enemy);
    public boolean getLose();
    public void setStrategy(Strategy strat);
    
    
}
