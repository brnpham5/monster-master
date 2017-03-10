/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Michael
 */
public class MMCampaign implements CampaignInterface{

    @Override
    public void play() {
        System.out.println("Monster Master Sim");
        System.out.println("1. New Game");
        System.out.println("2. Load Game");
        System.out.println("-------------------------");
    }

    @Override
    public String newGame() {
        //ret str = would you like to fight smart?
        //set first opponent
        return "";
    }

    @Override
    public String loadGame() {
        //find saves?
        //loop till all compatible saves are read{
        //ret str = #. save file names }
        //Have other function take input in client and load data?
        return "";
    }

    @Override
    public void battle() {
        //copy and paste duel code to here?
        //change duel code to work with one?
    }
    
}
