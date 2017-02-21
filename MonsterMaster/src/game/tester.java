package game;

import game.playerPackage.player;
import game.strategy.Dumb;
import game.strategy.Offensive;
import cards.Spells;
import cards.Monsters;
import java.util.Scanner;

import cards.*;

//Here is the tester for the game.
//The user will get to try 4 tests. 
//The first 3 tests test out the various valid moves of the game.
//The last test fully simulates a duel with a reduced variety of cards.
//For the last simulation, user will be asked a question to determine strategy 
//the player will use. The user must type in the letter y or the letter n. The 
//case does not matter. The game will then start as the players in the game will
//take turn. Game ends with one of the player's losing. A message will
//tell who won. The barrier at the start of the game will not be in effect
//to reduce complexity of program. Cards were cut out to reduce complexity
//of program. 
public class tester {
	public static void main(String[] args) throws InterruptedException{
		Scanner input = new Scanner(System.in);
		int counter = 1;
		Dumb planA = null;
		Offensive planB = null;
		
		Monsters group = new Monsters();
		Spells powers = new Spells();
		
		String choice = "";
		
		while(!choice.equals("5")){
			System.out.println("Select the simulation to run.");
			System.out.println("1. Monster Summoning.");
			System.out.println("2. Spell use.");
			System.out.println("3. Fight.");
			System.out.println("4. Full Duel Sim.");
			System.out.println("5. Quit.\n");
			choice = input.next();
		Offensive comp = new Offensive();
		
		player human = new player(planA,planB,"human");
		player cpu = new player(null,comp,"computer");
		
		if(choice.equals("1")){
			while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")){
				System.out.println("Would you like summon smart? Y/N \n");
				choice = input.next();
			}
			if(choice.equalsIgnoreCase("y")){
				human.planB = new Offensive();
			}
			else {human.planA = new Dumb();}
			System.out.println("Turn "+ counter);
			System.out.println("Human Hp: \t"+ human.getHp() +
				               "\t Computer Hp:\t"+ cpu.getHp());
			human.hand.clear();
			/*human.hand.add(group.greebler);
			human.hand.add(group.knight);
			human.hand.add(group.alien);*/
			human.turn(cpu);
			System.out.println("\n");
	
		}
		else
			if(choice.equals("2")){
				System.out.println("Turn "+ counter);
				System.out.println("Human Hp: \t"+ human.getHp() +
		               "\t Computer Hp:\t"+ cpu.getHp());
				human.planB = new Offensive();
				human.hand.add(powers.shield);
				human.hand.add(powers.sword);
				human.hand.add(powers.curse);
				/*human.field.add(group.greebler);
				cpu.field.add(group.greebler);*/
				human.turn(cpu);
				System.out.println("\n");
			}
		else
			if(choice.equals("3")){
				while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")){
					System.out.println("Would you like fight smart? Y/N \n");
					choice = input.next();
				}
				if(choice.equalsIgnoreCase("y")){
					human.planB = new Offensive();
				}
				else {human.planA = new Dumb();}
				System.out.println("Turn "+ counter);
				System.out.println("Human Hp: \t"+ human.getHp() +
					               "\t Computer Hp:\t"+ cpu.getHp());
				
				/*human.field.add(group.vampire);
				human.field.get(0).setHp(1);
				human.field.get(0).cooloff(1);
				human.field.add(group.greebler);
				human.field.get(1).cooloff(1);
				cpu.field.add(group.greebler);
				cpu.field.get(0).setDef(0);
				human.field.get(0).setHp(2);
				human.turn(cpu);
				System.out.println("\n");*/
			}
		if(choice.equals("4")){
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
		input.close();
	}
}