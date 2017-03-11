/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.players;

/**
 * For hand actions
 * Actions:
 * 1) display hand
 * 2) play a card from hand
 * 3)? discard
 * 
 * @author brnpham
 */
public interface hand_interface {
    public void printHand();
    public boolean playCard(int position);
}
