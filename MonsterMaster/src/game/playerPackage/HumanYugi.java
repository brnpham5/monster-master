/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.playerPackage;

import cards.YugiMonsters.Mon;
import cards.YugiSpells.Magic;
import java.util.Scanner;



/**
 *
 * @author Michael
 */
public class HumanYugi extends YugiPlayer{
    
    public HumanYugi(String name) {
        super(null, name);
    }
    
    
    public void turn(YugiPlayer enemy,int turn,Scanner input) {
        getCard();
        if(lose){return;}
        System.out.println("Main Phase");
        mainphase(enemy,input);
        if(turn != 1 && !field.isMonEmpty())
            battlePhase(enemy,input);
        endphase(input);
    }
    
    private void mainphase(YugiPlayer enemy,Scanner input){
        int choice; 
        do{
                System.out.println("\n\n=================\nCurrent Hand\n=================");
                hand.print();
                System.out.println("\n=================\nCurrent Field\n=================");
                field.print();
                System.out.println("Choose your next action with the corresponding number.");
                System.out.println("1. Summon Monster.");
                System.out.println("2. Use Spell.");
                System.out.println("3. Change Monster Position.");
                System.out.println("-1. Go to Battle Phase.");
                choice = input.nextInt();
                int[] handCheck = countHand();
                switch(choice){
                    case 1:
                        if(field.monSize() < field.MAXSIZE)
                            summonMonster(handCheck,input);
                        break;
                    case 2:
                        if(handCheck[13] > 0 && field.magicSize() != field.MAXSIZE)
                            useSpell(enemy,input);
                        break;
                    case 3:
                        if(!field.isMonEmpty())
                            switchMonPos(input);
                        break;
                    case -1: break;
                    default:
                        System.out.println("Wrong Number");
                }
        }while(choice != -1);
    }
    
    private void battlePhase(YugiPlayer enemy,Scanner input){
        int choice; 
        do{
            if(!canAttack())
                break;
            System.out.println("Select one of your monsters to attack. Use -1 to end battle phase.");
            choice = input.nextInt();
            if(choice >= 1 && choice <= field.monSize()){
                Mon card = field.getMon(choice-1);
                if(card.attackPos && !card.attacked){
                    int pos = choice-1;
                    if(!enemy.field.isMonEmpty()){
                        System.out.println("Select one of your enemy monster to attack.");
                        choice = input.nextInt();
                        if(choice >= 1 && choice <= enemy.field.monSize()){
                            card.attack(this,enemy,(choice-1),pos);
                            try{
                            field.getMon(pos).attacked = true;
                            }catch(NullPointerException er)    {
                                
                            }                    
                                }
                    else
                        System.out.println("Invalid move");
                    }
                else{
                    card.attack(this,enemy,-1,pos);
                    field.getMon(pos).attacked =true;
                    if(enemy.getLose())
                        choice = -1;
                    }
                }
            }
        }while(canAttack() && choice != -1);
    }
    
    
    /**
     * Here is the function when the player chooses to switch the position of their monsters.
     */
    private void switchMonPos(Scanner input){
            int choice;
            do{
            System.out.println("Select which monster on your field you would like switch its position.");
            System.out.println("Use the position number of the monster on the field.");
            System.out.println("Starts at 1. Ends at 5. Enter -1 to stop.");
            choice = input.nextInt();
                if(choice >= 1 && choice <= field.monSize()){
                    field.getMon(choice-1).switchPos();
                }
            }while(choice != -1);
    }
    
    
    
    /**
     * Here is the function that is called when the user wants to summon a monster.
     * @param handCheck An int array that carries number that tells if player has a monster in their hand.
     */
    private void summonMonster(int [] handCheck,Scanner input){
        int choice; 
        if(!summoned){
            if(handCheck[0] > 0){
                do{
                System.out.println("Choose postion of monster to summon from your hand.");
                choice = input.nextInt();
                if(choice >= 1 && choice <= hand.size()){
                    
                if(hand.get(choice-1) instanceof Mon){
                    summoned = true;
                    int pos = choice-1;
                    do{
                    System.out.println("Select postion of summoned monster.");
                    System.out.println("Select 0 to summon monster in attack position.");
                    System.out.println("Select 1 to summon monster in defense position.");
                    choice = input.nextInt();
                    if(choice == 0 || choice == 1){
                        Mon card = (Mon)hand.get(pos);
                        if(choice == 0)
                            card.summon(this,true);                      
                        else
                            card.summon(this, false);
                    }
                    else
                        System.out.println("Invalid Choice.");
                    }while(choice != 0 && choice != 1);
                }
                else
                    System.out.println("That was not a monster card. Choose again.");
                }
                else
                    System.out.println("Wrong Number");
                }while(!summoned);
            }
            else
                System.out.println("No monsters in hand.");
        }
        else
            System.out.println("Cannot summon monster.");
    }
    
    
    private void useSpell(YugiPlayer enemy,Scanner input){
        int choice; 
            do{
            System.out.println("Choose a spell card to use from your hand.");
            System.out.println("Select the card position.");
            choice = input.nextInt();
            if(choice >= 1 && choice <= hand.size()){
                int pos = choice-1;
                if(hand.get(choice-1) instanceof Magic){
                    Magic card = (Magic)hand.get(choice-1);
                    if(card.getCategory() == 2){
                        if(card.getName().equals("Salamandra") && !field.findElement(2)){
                            System.out.println("Card cannot be used without fire element monster.");
                        }
                        do{
                        System.out.println("Select position of monster to equip from your field. Use -1 to cancel spell.");
                        choice = input.nextInt();
                        if(choice >= 1 && choice <= field.monSize()){
                            pos = choice;
                            if(card.getName().equals("Salamandra")){
                                if(field.getMon(choice-1).getEle() == 2){
                                    card.effect(this, enemy, choice-1, pos);
                                    hand.remove(pos);
                                    choice = -1;
                                }    
                            }
                            else{
                                card.effect(this, enemy, choice-1, pos);
                                hand.remove(pos);
                                choice = -1;
                            }
                        }
                        else if(choice == -1){
                            System.out.println("Spell canceled");
                        }
                        }while(choice != -1);
                    }
                    else{
                        if(card.getName().equals("Nephthy's Curse")){
                            if(!enemy.field.isMonEmpty()){
                                do{
                                    System.out.println("Select position of monster from enemy field. Use -1 to cancel spell.");
                                    choice = input.nextInt();
                                    if(choice >= 1 && choice <= enemy.field.monSize()){
                                          hand.get(choice-1).effect(this, enemy, choice-1, pos);
                                          choice = -1;
                                    }
                                    else if(choice == -1)
                                        System.out.println("Spell Canceled");      
                                }while(choice != -1);
                            }
                        }
                        else
                            card.effect(this, enemy, 0, pos);
                        hand.remove(pos);
                    }
                }
            }
            }while(choice != -1);
    }
    
    
    /**
     * This the function called when the player is at the end of their turn.
     */
    private void endphase(Scanner input){
	summoned = false;
	for(int loop = 0; loop < field.monSize();loop++){
            if(field.getMon(loop).attacked){
		field.getMon(loop).attacked = false;
            }
	}
        while(hand.getSize() > 7){
            System.out.print("You have too many cards in your hand.\n"
                            +"Please discard one card. Select the card with its "
                            +"position number in hand.\n Starting at 1." );
            int position = input.nextInt();
            if(position <= hand.getSize() && position >= 0)
                hand.remove(position-1);
        }
        System.out.println("Your turn ends.");
    }
    
}
