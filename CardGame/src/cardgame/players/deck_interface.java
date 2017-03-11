/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.players;

/**
 *
 * @author brnpham
 */
public interface deck_interface {
    public int draw();
    public int search(String name);
    public int searchType(String type);
    public void shuffle();
    public int size();
    public boolean isEmpty();
}
