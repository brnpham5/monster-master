/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.playerPackage.HumanYugi;
import game.playerPackage.YugiPlayer;
import game.strategy.DumbYugi;
import game.strategy.OffensiveYugi;
import java.util.Scanner;

/**
 *
 * @author Michael
 */
public class YugiCampaign implements CampaignInterface{
    private HumanYugi human;
    
    private YugiPlayer cpu;
    
    public int state = 0;
    
    public static void main(String[] args) throws InterruptedException{
        YugiCampaign game = new YugiCampaign();
        game.play();
    }
    
    
    
    @Override
    public void play(){
        
        /*try (Scanner input = new Scanner(System.in)) {
            int choice = 0;
            while(state == 0){*/
                System.out.println("Yu-gi-oh Sim");
                System.out.println("1. New Game");
                System.out.println("2. Load Game");
                System.out.println("-------------");
                /*choice = input.nextInt();
            }   if (choice == 1) {
                newGame(input);
            }
            //
        }*/
    }
    
    
    @Override
    public void newGame(Scanner input) throws InterruptedException{
        human = new HumanYugi("Human");
        cpu = new YugiPlayer(new DumbYugi(),"Computer");
        int result = battle(input);
        switch (result) {
            case 0:
                {
                    System.out.println("Continue?");
                    String choice = "";
                    while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")){    
                        System.out.println("Enter y to retry or n to quit\n");
                        choice = input.next();
                    }   if(choice.equalsIgnoreCase("y")){
                        human.restart();
                        cpu = new YugiPlayer(new DumbYugi(),"Computer");
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
                human = new HumanYugi("Human");
                cpu = new YugiPlayer(new DumbYugi(),"Computer");
                battle(input);
                break;
        }
            
    }
    
    /**
     * This is the function that handles the card duels in yu-gi-oh.
     * @param input This is the scanner that reads in player input.
     * @return A 1 or 0 depending on who wins. 1  = Human win. 0 = Computer win.
     * @throws InterruptedException 
     */
    @Override
    public int battle(Scanner input) throws InterruptedException{
        int counter = 1;
        while(!human.getLose() && !cpu.getLose()){
            System.out.println("Turn "+ counter);
            System.out.println("Human Hp: \t"+ human.getHp() +
		               "\t Computer Hp:\t"+ cpu.getHp());
            System.out.println(human.id);
            human.turn(cpu,counter,input);
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


    @Override
    public void loadGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
