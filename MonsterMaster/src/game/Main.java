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
    
    private final MMCampaign gameM = new MMCampaign();
    
    private final YugiCampaign gameY = new YugiCampaign();
    
    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {
        // fire to localhost port 1099
        Registry myRegistry = LocateRegistry.getRegistry(1099);

        // search for Client service
        Client remote = (Client) myRegistry.lookup("Game");
        
        //Variable used in this function.
        String line;
        Main self = new Main();
        char game;
        
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
                    self.startMM(remote,input); remote.endGame(); break;                   
                case 'Y':
                    self.startY(remote,input); remote.endGame(); break;
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
     * This is the function to play Monster Master
     * @param remote This is the client service from the server
     * @param in The scanner that reads in user input
     * @throws RemoteException 
     */
    private void startMM(Client remote,Scanner in) throws RemoteException{
        int state = 0;
        do{
        //Bring up Main memu
        gameM.play();
        int choice = in.nextInt();
        try {
                remote.gameMainMenu(choice);
                state = remote.getState();
            } catch (RemoteException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(state == 0);
        //if state == 1
            //call new game
            //Ask player question to set Ai?  Make class for human input?  
        //else 
            //call load game
            //get input
            //send game to load? client do it?
        //while loop{
        //call battle, let it print then get result
            //let player save data during turn.
            //if human is playing then have loop that ends when result of battle is found
                //print life and turn counter
                //while loop?{ coninute as long as its huamn turn. 
                    //only do this if client is handling input else let human obj in campaign do it
                    //print current human hand  and field. print comp field
                    //print prompt of actions user can take
                    //get input and send to client? let player obj handle instead?
                    //if valid moves done then print hand and fields for up date
                //}
                //when human turn finish call cpu to take turn and print their field
        //set player data with updated w/d/l values
        //depending on result load new opponent or redo battle?
        //check to see if final opponent lost
        //} quit when final battle is done.
        //Give end game message?  
    }
    
    private void startY(Client remote,Scanner in) throws InterruptedException{
        int state = 0;
        do{
        //Bring up Main memu
        gameY.play();
        int choice = in.nextInt();
            try {
                remote.gameMainMenu(choice);
                state = remote.getState();
            } catch (RemoteException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }while(state == 0);
        if(state == 1)
            gameY.newGame(in);
        else
            state = 9; // place holder.
            //gameY.loadGame();
        System.out.println("You have finished the campaign for Yu-Gi-Oh.");
    }
}
