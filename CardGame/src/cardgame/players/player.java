/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.players;

/**
 * Player Properties
 * Health:          //Health of player
 * Name:            //Name of player
 * Win:             //Win counter
 * Draw:            //Draw counter
 * Loss:            //Loss counter
 * Alive:           //Boolean that tells whether the player is alive or dead
 * 
 * Methods:
 * addWin()         //increment win counter
 * addLoss()        //increment loss counter
 * addDraw()        //increment draw counter
 * takeDamage(int damage)   //deals damage amount to player 
 * @author brnpham
 */
public class player implements player_interface{
    //health amount
    protected int health;
    
    //name of the player
    protected String name;
    
    //total play data
    protected int win = 0, draw = 0, loss = 0;
    
    //Flag that tells if the player is still in the game
    //True = alive
    //False = dead/lose
    public boolean alive = true;
    
    public player(){
        this.name = "DEFAULT";
    }
    
    public player(String name) {
        this.name = name;
    }
    
//Game Methods
    //Add a win to the win counter
    public void addWin(){
        this.win++;
    }
    
    //Add a loss to the loss counter
    public void addLoss(){
        this.loss++;
    }
    
    //Add a draw to the draw counter
    public void addDraw(){
        this.draw++;
    }
    
    //Take damage method
    //Reduce the player's health by the damage amount
    //If health reduces below 0, set alive to false (player is dead)
    public void takeDamage(int damage){
        this.health -= damage;
        if(health <= 0){
            this.alive = false;
        }
    }
    
//Getters and Setters
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }
    
}
