/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
        
import java.util.Scanner;

/**
 *
 * @author Michael
 */
public class Game extends Duel{ 
    public static void main(String[] args) throws InterruptedException{
        Game start;
        Scanner input = new Scanner(System.in);
        System.out.println("Pick a game to play. Input the number.");    
        System.out.println("1. Monster Master");
        System.out.println("2. Yugioh Sim");
        System.out.println("3. Yugioh Duel");
        int choice = 0;
            while(choice <= 0 || choice > 3){
		System.out.println("Please choose a valid number \n");
		choice = input.nextInt();
            }
        start = new Game(choice);
        start.play();
    }

    public Game(int game) {
        switch(game){
            case 1:
                super.setDuel("MM"); return;
            case 2:
            case 3:    
                super.setDuel("Yugi");
        }
    }
}