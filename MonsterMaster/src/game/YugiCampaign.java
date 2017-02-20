/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.playerPackage.YugiPlayer;
import game.strategy.DumbYugi;
import game.strategy.OffensiveYugi;
import java.util.Scanner;

/**
 *
 * @author Michael
 */
public class YugiCampaign {
    private YugiPlayer human;
    
    private YugiPlayer cpu;
    
    
    public static void main(String[] args) throws InterruptedException{
        YugiCampaign game = new YugiCampaign();
        game.play();
    }
    
    
    
    public void play() throws InterruptedException{
        
        try (Scanner input = new Scanner(System.in)) {
            int choice = 0;
            while(choice != 1 && choice != 2){
                System.out.println("Yu-gi-oh Sim");
                System.out.println("1. New Game");
                System.out.println("2. Load Game");
                System.out.println("-------------");
                choice = input.nextInt();
            }   if (choice == 1) {
                human = new YugiPlayer(new OffensiveYugi(),"Human");
                cpu = new YugiPlayer(new DumbYugi(),"Computer");
                newGame();
            }
            //
        }
    }
    
    
    
    public void newGame() throws InterruptedException{
        int result = battle();
        if(result == 0){
            System.out.println("Continue?");
            try (Scanner input = new Scanner(System.in)) {
                String choice = "";
                while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")){
                System.out.println("Enter y to retry or n to quit\n");
                choice = input.next();    
                }
                if(choice.equalsIgnoreCase("y")){
                    human = new YugiPlayer(new OffensiveYugi(),"Human");
                    cpu = new YugiPlayer(new DumbYugi(),"Computer");
                    newGame();
                }
                else{
                    //Load game here
                }
            }
        }
        else{
            human = new YugiPlayer(new OffensiveYugi(),"Human");
            cpu = new YugiPlayer(new DumbYugi(),"Computer");
            battle();
        }
            
    }
    
    public int battle() throws InterruptedException{
        int counter = 1;
        while(!human.getLose() && !cpu.getLose()){
            System.out.println("Turn "+ counter);
            System.out.println("Human Hp: \t"+ human.getHp() +
		               "\t Computer Hp:\t"+ cpu.getHp());
            System.out.println(human.id);
            human.turn(cpu,counter);
            Thread.sleep(1000);
            System.out.println("\n"+cpu.id);
            if(human.getLose() || cpu.getLose()){break;}
            cpu.turn(human,counter);
            counter++;
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
