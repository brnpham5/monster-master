/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.playerPackage.YugiPlayer;
import game.playerPackage.player;
import game.playerPackage.playerInterface;
import game.strategy.Dumb;
import game.strategy.DumbYugi;
import game.strategy.Offensive;
import game.strategy.OffensiveYugi;
import java.util.Scanner;

/**
 *
 * @author Michael
 */
public class Duel {
    
    private playerInterface human;
    private playerInterface cpu;
    
    public void setDuel(String duel){
        if(duel.equals("MM")){
            MMSetup();
        }
        else if(duel.equals("Yugi")){
            YugiSetup();
        }
    }
          
    
    
    public void MMSetup(){
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
    }
    
    
    public void YugiSetup(){
        human = new YugiPlayer(null,"Human");
        cpu = new YugiPlayer(new OffensiveYugi(),"Computer");
        Scanner input = new Scanner(System.in);
            
            
        String choice = "";
        while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")){
            System.out.println("Would you like fight smart? Y/N \n");
            choice = input.next();
        }
        if(choice.equalsIgnoreCase("y")){
            human.setStrategy(new OffensiveYugi());
        }
	else {human.setStrategy(new DumbYugi());}
    }
    
    
    public void play() throws InterruptedException{
        int counter = 1;
        
        
	while(!human.getLose() && !cpu.getLose()){
            
            System.out.println("Turn "+ counter);
            System.out.println("Human Hp: \t"+ human.getHp() +
		               "\t Computer Hp:\t"+ cpu.getHp());
            if(human instanceof YugiPlayer){
                System.out.println(human.toString());
                System.out.println(cpu.toString());
                human.turn((YugiPlayer)cpu);
                System.out.println("\n");
                if(human.getLose() || cpu.getLose()){break;}
                cpu.turn((YugiPlayer) human);
                }
            else if(human instanceof player){
                human.turn((player)cpu);
                System.out.println("\n");
                if(human.getLose() || cpu.getLose()){break;}
                cpu.turn((player) human);}
            counter++;
            Thread.sleep(1000);
            System.out.println("\n");
	}
	if(human.getLose()){
            if(human.getHp() <= 0)
                System.out.println("Computer wins. Human lost all life.");
            else
                System.out.println("Computer wins. Human can't draw.");
	}
	else {
            if(cpu.getHp() <= 0)
                System.out.println("Human wins. Computer lost all life.");
            else
                System.out.println("Humans wins. Computer can't draw.");
	}
    }
}
