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
public class Duel {
    public void play() throws InterruptedException{
        player human = new player(null,null,"Human");
        player cpu = new player(null,new Offensive(),"Computer");
        Scanner input = new Scanner(System.in);
	int counter = 1;
	Dumb planA = null;
	Offensive planB = null;
        String choice = "";

        
        while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")){
				System.out.println("Would you like fight smart? Y/N \n");
				choice = input.next();
			}
			if(choice.equalsIgnoreCase("y")){
				human.planB = new Offensive();
			}
			else {human.planA = new Dumb();}
		
			while(!human.lose && !cpu.lose){
				System.out.println("Turn "+ counter);
				System.out.println("Human Hp: \t"+ human.getHp() +
					               "\t Computer Hp:\t"+ cpu.getHp());
				human.turn(cpu);
				System.out.println("\n");
				if(human.lose || cpu.lose){break;}
				cpu.turn(human);
				counter++;
				Thread.sleep(1000);
				System.out.println("\n");
			}
			if(human.lose){
				if(human.getHp() <= 0){System.out.println("Computer wins. Human lost all life.");
				}
				else{System.out.println("Computer wins. Human can't draw.");
				}
			}
			else {if(cpu.getHp() <= 0){System.out.println("Human wins. Computer lost all life.");
				}
				else{System.out.println("Humans wins. Computer can't draw.");}
			}
    }
}
