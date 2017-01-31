package game;

import cards.*;
import java.util.ArrayList;


//Here is the move class with the various legal moves a player can do.
//The strategy classes will switch the flags to true to tell the player class
//which moves to do. The 3 types of moves a player can do are summon a monster,
//use a spell, and attack. The functions in this class will work together to 
//complete those 3 types of moves.
public class move {
	
	
	//These are flags that the different strategy classes will
	//switch to do various moves in the game. 
	public boolean summonAtk = false;
	public boolean summonDef = false;
	public boolean summon = false;
	public boolean buffAtk = false;
	public boolean buffDef = false;
	public boolean curse = false;
	public boolean attack = false;
	public boolean pass = false;
	
	
	//Function will check player's hand for monsters.
	//Function will return the highest attack value that the program
	//first encounters. If no monsters are encountered return null.
	//This function is used by the offensive strategy.
	public void summonStrongest(player user){
		Monster monster = null;
		int highestAtk = 0;
		int position = -1;
		for(int loop = 0; loop < user.hand.size(); loop++){
			if(user.hand.get(loop).getType() == "monster"){ 
				Monster mon = (Monster)user.hand.get(loop);
				if(mon.getAtk() > highestAtk){
					position = loop;
					highestAtk = mon.getAtk();
				}
			}
		}
		if (position != -1){ 
			monster = (Monster)user.hand.get(position);
			user.field.add(monster);
			user.hand.remove(monster);
			System.out.println(user.id +" summoned "+ monster.getName());
			}
		else{System.out.println(user.id +" does not summon.\n");}
		}
	
	
	//This function looks through the user's hand and chooses the monster 
	//with the highest defense value. If there is no monsters in the hand then
	//the user does not summon.
	public void summonDefensive(player user){
		Monster monster = null;
		int highestDef = 0;
		int position = -1;
		for(int loop = 0; loop < user.hand.size(); loop++){
			if(user.hand.get(loop).getType() == "monster"){ 
				Monster mon = (Monster)user.hand.get(loop);
				if(mon.getDef() > highestDef){
					position = loop;
					highestDef = mon.getDef();
				}
			}
		}
		if (position != -1){ 
			monster = (Monster)user.hand.get(position);
			user.field.add(monster);
			user.hand.remove(monster);
			System.out.println(user.id +" summoned "+ monster.getName());
			}
		else{System.out.println(user.id +" does not summon.\n");}
		}
	
	
	//Function will search through player's hand
	//Summons the first monster encountered by the function.
	//This function will be used by the dumb strategy.
	public void summon(player user){
		Monster monster = null;
		for(int loop = 0; loop < user.hand.size(); loop++){
			if(user.hand.get(loop).getType() == "monster"){ 
				monster = (Monster)user.hand.get(loop);
				break;
				}
			}
		if (monster != null){ 
			user.field.add(monster);
			user.hand.remove(monster);
			System.out.println(user.id +" summoned "+ monster.getName());
			}
		else{System.out.println(user.id +" does not summon.\n");}
	}
	
	
	//Function will look through the player's field.
	//The function will select the player's monster with the highest attack
	//that does not already have a sword.
	//The function will return the position of the selected monster.
	//If there is no applicable monsters then position will return as -1.
	public void aBuff(player user){
		int pos = -1;
		int highest = 0;
		int loc = 0;
		for(int look = 0; look < user.hand.size(); look++){
			if(user.hand.get(look).getName().equals("sword")){
				loc = look;
				break;
			}
		}
		for(int loop = 0; loop < user.field.size(); loop++){
			Monster mon = user.field.get(loop);
				if(mon.getAtk() > highest && mon.getHp() == mon.maxhp && !mon.sword){
					pos = loop;
					highest = mon.getAtk();
				}
			}
		if(pos != -1){
                    user.hand.get(loc).effect(user, null, highest, pos);
		}
	}
	
	
	//Function will look through the player's field.
	//The function will select the player's monster with the highest defense 
	//that does not already have a shield.
	//The function will return the position of the selected monster.
	//If there is no applicable monsters then position will return as -1.
	public void dBuff(player user){
		int pos = -1;
		int highest = 0;
		int loc = 0;
		for(int look = 0; look < user.hand.size(); look++){
			if(user.hand.get(look).getName().equals("shield")){
				loc = look;
				break;
			}
		}
		for(int loop = 0; loop < user.field.size(); loop++){
			Monster mon = user.field.get(loop);
				if(mon.getDef() > highest && mon.getHp() == mon.maxhp && !mon.shield){
					pos = loop;
					highest = mon.getDef();
				}
			}
		if(pos != -1){
                    user.hand.get(loc).effect(user, null, highest, pos);
		}
	}
	
	
	//Function will look through the enemy's field.
	//The function will select the enemy's strongest monster that is not cursed.
	//The function will return the position of the selected monster.
	//If there is no applicable monsters then position will return as -1.
	public void debuffMon(player user, ArrayList <Monster> arena){
		int pos = -1;
		int highest = 0;
		int loc = 0;
		for(int look = 0; look < user.hand.size(); look++){
			if(user.hand.get(look).getName().equals("curse")){
				loc = look;
				break;
			}
		}
		
		for(int loop = 0; loop < arena.size(); loop++){
			Monster mon = arena.get(loop);
				if(mon.getAtk() > highest && !mon.curse){
					pos = loop;
					highest = mon.getAtk();
				}
			}
		if(pos != -1){
                    user.hand.get(loc).effect(user, null, highest, pos);
		}
	}
	
	
	//The function will go through the player's whole field
	//and get each monster to attack. The monster's target is
	//dependent on strategy used. If the opponent loses all their health then
	//the attacking stops. This function will call the monster's effect function
        //to attack the target. The monster will only attack if their placed value equals
        //zero.
	public void battle(player user, player enemy,boolean hard){
		for(int attacks = 0; attacks < user.field.size();attacks++){
			int pos;
			
			//Position of target is calculated here.
			if(!hard){pos = attack(enemy.field);}
			else{pos = AttackWeak(enemy.field);}
			
			//If the attacking monster's summoning cooldown is less than 0.
			//Go through attack sequence. If not the monster does not attack
			//and its summoning cooldown is reduced by 1.
			//If the monster attacks use move function called fight.
			//Fight will return a number that tells if attacker wins battle
			//or not. Fight method only called if attacker's target is a monster.
			//If not then full attack value is subtracted from opponent's health.
			if(user.field.get(attacks).getPlaced() <= 0){
				user.field.get(attacks).attacked = true;
                                user.field.get(attacks).effect(user, enemy, pos,attacks);
                                if(enemy.lose){break;}
			}	
		}
	}
	
	
	//Looks through a player's field and returns the position of the monster
	//with the lowest defense. Return -1 if there is no monsters on the field.
	private int AttackWeak(ArrayList <Monster> field){
		int position = -1;
		int weakest = 12;
		for(int loop = 0; loop < field.size(); loop++){
			Monster mon = field.get(loop);
				if(mon.getDef() < weakest){
					position = loop;
					weakest = mon.getDef();
				}
			}
		return position;
	}
	
	
	//Looks through a player's field returns 0 if there is a monster on the field.
	//Returns a -1 if there's no monster on the field.
	private int attack(ArrayList <Monster> field){
		if(field.size() > 0){return 0;}
		else {return -1;}
	}
}