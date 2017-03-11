/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Scanner;
import game.playerPackage.player;
import game.strategy.Dumb;
import game.strategy.Offensive;

/**
 *
 * @author Michael
 */
public class MMCampaign implements CampaignInterface{
    private player human;
    private player cpu;
    
    /**
     * Function that prints out the starting menu for the game
     */
    @Override
    public void play() {
        System.out.println("Monster Master Sim");
        System.out.println("1. New Game");
        System.out.println("2. Load Game");
        System.out.println("-------------------------");
    }

    /**
     * The new game function that is chosen by the user or if there is no saved game.
     * @param in
     * @throws InterruptedException 
     */
    @Override
    public void newGame(Scanner in) throws InterruptedException {
        human = new player(null,null,"Human");
        cpu = new player(null,new Offensive(),"Computer");
        Scanner input = new Scanner(System.in);
               
        String choice = "";
        while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")){
            System.out.println("Would you like fight smart? Y/N \n");
            choice = input.next();
        }
        if(choice.equalsIgnoreCase("y")){
            human.setStrategy(new Offensive());
	}
	else {human.setStrategy(new Dumb());}
         int result = battle(input);
        switch (result) {
            case 0:
                {
                    System.out.println("Continue?");
                    choice = "";
                    while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")){    
                        System.out.println("Enter y to retry or n to quit\n");
                        choice = input.next();
                    }   if(choice.equalsIgnoreCase("y")){
                        human.restart();
                        cpu = new player(new Dumb(),null,"Computer");
                        newGame(input);
                    }
                    else{
                        //Load game here or exit game?
                    }   break;
                }
            case 1:
                {
                    //This could be call to another function
                    //which loads in next character and starts battle.
                   //Load next character 
                    human.restart();
                    //battle
                }
            default:
                human = new player(new Dumb(),null ,"Human");
                cpu = new player(new Dumb(),null,"Computer");
                battle(input);
                break;
        }
    }

    @Override
    public void loadGame() {
        //find saves?
        //load data then call battle
    }

    @Override
    public int battle(Scanner input) throws InterruptedException {
        int counter = 1;
        while(!human.getLose() && !cpu.getLose()){
            System.out.println("Turn "+ counter);
            System.out.println("Human Hp: \t"+ human.getHp() +
		               "\t Computer Hp:\t"+ cpu.getHp());
                human.turn(cpu);
                System.out.println("\n");
                //Ask the user if they would like to save their progress
                //If yes save progress and move on.
                //If no move on
                if(human.getLose() || cpu.getLose()){break;}
                cpu.turn(human);
            counter++;
            Thread.sleep(1000);
            System.out.println("\n");
	}
	if(human.getLose()){
            if(human.getHp() <= 0)
                System.out.println("Computer wins. Human lost all life.");
            else
                System.out.println("Computer wins. Human can't draw.");
            return 0;
	}
	else {
            if(cpu.getHp() <= 0)
                System.out.println("Human wins. Computer lost all life.");
            else
                System.out.println("Humans wins. Computer can't draw.");
            return 1;
	}
    }
    
}
