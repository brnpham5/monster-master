package game;

import cards.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


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
			if(user.hand.get(look).getName() == "sword"){
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
			user.field.get(pos).sword = true;
			user.hand.remove(loc);
			System.out.println(user.id + " used sword on " + user.field.get(pos).getName());
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
			if(user.hand.get(look).getName() == "shield"){
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
			user.field.get(pos).shield = true;
			user.hand.remove(loc);
			System.out.println(user.id + " used shield on " + user.field.get(pos).getName());
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
			if(user.hand.get(look).getName() == "curse"){
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
			arena.get(pos).curse = true;
			user.hand.remove(loc);
			System.out.println(user.id + " used curse on " + arena.get(pos).getName());
		}
	}
	
	
	//The function will go through the player's whole field
	//and get each monster to attack. The monster's target is
	//dependent on strategy used. If any monster dies then they
	//are removed here. If the opponent loses all their health then
	//the attacking stops. Battle calculations happen here. 
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
				if(pos != -1){
					int dmg = fight(user.field.get(attacks),enemy.field.get(pos));
					System.out.println(user.field.get(attacks).getName()+" attacks "+enemy.field.get(pos).getName());
					if(dmg < 0){
						if(user.field.get(attacks).getName().equals("alien")){continue;}
						else { 
							user.field.get(attacks).setHp(dmg);
							System.out.println(user.field.get(attacks).getName()+" deals " + (-dmg) +" damage.");
							if(user.field.get(attacks).getHp() <= 0){
								System.out.println(user.field.get(attacks).getName() + " dies");
								user.field.remove(attacks);
							}
						}
					}
					else if(dmg > 0){
						enemy.field.get(pos).setHp(dmg);
						if(enemy.field.get(pos).getHp() == 0){
							System.out.println(enemy.field.get(pos).getName() + " dies");
							enemy.field.remove(pos);}
						if(user.field.get(attacks).getName().equals("vampire")){
							user.field.get(attacks).setHp(dmg);
							System.out.println("vampire heals");
						}
					}
				}
				else{
				System.out.println(user.field.get(attacks).getName() +" attacks directly for "+ user.field.get(attacks).getAtk()+ " damage.");
				enemy.setHp(user.field.get(attacks).getAtk());
				if(enemy.lose){break;}
				}			
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
	
	
	//This is the function that does battle calculations.
	//The function will create 2 randomly generated numbers.
	//One will take the attacking monster's attack value and the
	//other number will take the defending monster's defense value.
	//The range of the 2 numbers be between 0 and their respective 
	//values. The difference of the two number wills be returned.
	public int fight(Monster p, Monster c){
		int atk = ThreadLocalRandom.current().nextInt(0,p.getAtk()+1);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int def = ThreadLocalRandom.current().nextInt(0,c.getDef()+1);
		
		return atk-def;
	}
}
