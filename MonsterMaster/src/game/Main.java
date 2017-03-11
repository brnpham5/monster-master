/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the main class for the project. This needs to be run after server has been started.
 * @author Michael
 */
public class Main {

    
    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {
        // fire to localhost port 1099
        Registry myRegistry = LocateRegistry.getRegistry(1099);

        // search for Client service
        Client remote = (Client) myRegistry.lookup("Game");
        
        //Variable used in this function.
        String line;
        Main self = new Main();
        char game;
        CampaignInterface cardGame;
        
        try (Scanner input = new Scanner(System.in)) {
            do{
            //Print start menu and get user input.
            startprompt();
            int choice = input.nextInt();
            
            //Get result of user input. Will have a game choosen or state changed in client.
            line = remote.chooseGame(choice);
            if(!line.isEmpty())
                System.out.println(line);   //Print string feedback depending on user input
            game = remote.getGame();
            switch(game){                   //Depending on choice start a game, end program, or say invalid choice made.
                case 'M':
                    cardGame = new MMCampaign();
                    self.start(remote,input,cardGame); 
                    remote.endGame(); break;                   
                case 'Y':
                    cardGame = new YugiCampaign();
                    self.start(remote,input,cardGame); 
                    remote.endGame(); break;
                case '-':
                    if(remote.getState() == -1)
                        break;
                default:
                    System.out.println("Invalid choice please select again.\n");
            }
            }while(remote.getState() != -1);      
        }
        System.out.println("Program exited.");
    }
    
    /**
     * Starting menu prompt for program. This will be called by main each time 
     * program is started or if invalid input happens on start menu 
     */
    private static void startprompt(){
        System.out.println("Welcome to Card Links.");
        System.out.println("Please choose the card game you would like to play.");
        System.out.println("Use the number next to the game as input.");
        System.out.println("1) Monster Master");
        System.out.println("2) Yu-gi-oh");
        System.out.println("3) Exit Program\n");
    }

    /**
     * The function that starts the game the user chose.
     * @param remote The remote that gets input and switch the state of program.
     * @param in the scanner which reads in user input
     * @param game the campaign interface which the program uses to run the game.
     * @throws InterruptedException 
     */
    private void start(Client remote,Scanner in,CampaignInterface game) throws InterruptedException{
        int state = 0;
        do{
        //Bring up Main memu
        game.play();
        int choice = in.nextInt();
            try {
                remote.gameMainMenu(choice);
                state = remote.getState();
            } catch (RemoteException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }while(state == 0);
        if(state == 1)
            game.newGame(in);
        else
            state = 9; // place holder.
            //game.loadGame();
        System.out.println("You have finished the campaign for Yu-Gi-Oh.");
    }
}
