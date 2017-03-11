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
public interface player_interface {
    public void addWin();
    public void addLoss();
    public void addDraw();
    
    public int getHealth();
    public void setHealth(int health);
    public String getName();
    public void setName(String name);
    public int getWin();
    public void setWin(int win);
    public int getDraw();
    public void setDraw(int draw);
    public int getLoss();
    public void setLoss(int loss);
    
}
