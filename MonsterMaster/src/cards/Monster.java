package cards;

import cards.Card;
import game.playerPackage.player;
import java.util.concurrent.ThreadLocalRandom;

//Below are the code needed for a monster card from
//monster masters. This does not completely mimic the 
//functionality of game's monster cards, but have enough
//to be similar to the game.
public class Monster implements Card {
	
	//Attributes that a monster card has in game.
	//The name of the monster.
	protected String name;
	
	
	//The attack value of the monster.
	//Attack value is the damage the monster does to opposing player.
	//Attack value is maximum amount of damage that monsters can do to
	//another monster. Used in damage calculation.
	protected int attack;
	
	
	//The defense value of the monster.
	//Defense value is the maximum amount damage the monster does to its
	//attacker. Used in damage calculation.
	protected int defense;
	
	
	//The life points that the monster has.
	//This value decreases depending on the out comes of battles.
	//This can be increase with the restore spell.
	//If this monster is vampire then it can gain health if it does damage.
	protected int health;
	
	
	//This is the max amount of life a monster can have.
	//Monsters cannot have more life than this. If they are healed for more
	//than this value then their health equals this.
	public int maxhp;
	
	
	//This is the how long the monster cannot attack after being summoned.
	//When the placed value is 0 then the monster can attack. The placed
	//value will decrease by 1 at the end of the user's turn.
	protected int cooldown;
	protected int placed;
	
	
	//These are flags for the different spells used on the monster
	//These are switched to true when spells are used on them.
	public boolean shield = false;
	public boolean sword = false;
	public boolean curse = false;
        public boolean firesword = false;
        public boolean iceshield = false;
	
	
	//Flag that tells if the monster has attacked during the turn.
	public boolean attacked = false;
	
	
	//Default Constructor of monsters. Has almost every attribute that
	//monsters had in game. Only some stuff was exclude for reduded 
	//complexity.
	public Monster(String id, int atk, int def, int cd,int hp){
		name = id;
		attack = atk;
		defense = def;
		cooldown = cd;
		health = hp;
		maxhp = hp;
		placed = cd;
	}
	
	
        
        //This function how monsters usually attack.
        //Most monsters will use this when told to attack.
        //Some monsters will need to override this to let their special ability happen.
        //This function will do battle calculation. The function will remove any monster
        //Killed and changes the health values of monsters or player to reflect the outcomes.
        public void effect(player owner, player enemy,int target,int position){
            if(target != -1){
		int dmg = fight(this,enemy.field.get(target));
		System.out.println(name+" attacks "+enemy.field.get(target).getName());
		if(dmg < 0){
                    setHp(dmg);
                    System.out.println(enemy.field.get(target).getName()+" deals " + (-dmg) +" damage.");
                    if(health <= 0){
                        System.out.println(name + " dies");
                        owner.field.remove(position);
			}
		}
		else if(dmg > 0){
                    enemy.field.get(target).setHp(dmg);
                    if(enemy.field.get(target).getHp() <= 0){
                        System.out.println(enemy.field.get(target).getName() + " dies");
                        enemy.field.remove(target);}
			}
                    }
                    else{
			System.out.println(name +" attacks directly for "+ attack+ " damage.");
				enemy.setHp(attack);
            }
        }
        
        //This is the function that does battle calculations.
	//The function will create 2 randomly generated numbers.
	//One will take the attacking monster's attack value and the
	//other number will take the defending monster's defense value.
	//The range of the 2 numbers be between 0 and their respective 
	//values. The difference of the two number wills be returned.
	protected int fight(Monster p, Monster c){
		int atk = ThreadLocalRandom.current().nextInt(0,p.getAtk()+1);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int def = ThreadLocalRandom.current().nextInt(0,c.getDef()+1);
		
		return atk-def;
	}
	//Setters Getters for move and strategy classes
	//to use to get the game going.
	//Values that can be changed here are
	//attack, health, defense and placed.
	//Values obtained from here are the type,
	//name, defense, attack, placed, and health.
	public String getType(){ return "monster"; }
	
	public String getName(){ return name; }
	
	public void setAtk(int atk){ attack = atk; }
	
	public int getAtk(){ 
		int modifier = 0; 
		if(sword){modifier += 2;}
		if(curse){modifier -= 1;}
                if(firesword){modifier += 4;}
		return (attack + modifier); }
	
	public void setDef(int def){ defense = def;}
	
	public int getDef(){
		int modifier = 0; 
		if(shield){modifier += 2;}
		if(curse){modifier -= 1;}
                if(iceshield){modifier += 4;}
		return (defense + modifier); }
	
	public void summoned(){ placed = cooldown;} 
	
	public void cooloff(int cool){
		if(placed > 0){
		placed -= cool;}
		}
	
	public int getPlaced(){return placed;}
	
        public void setPlaced(int value){placed = value;}
        
        
        //Setter for monster's health value.
        //Positive numbers = damage
        //Negative numbers = healing
	public void setHp(int hp){
		if((-hp + health) > maxhp){ health = maxhp;}
		else {health -= hp;}
	}
	
	public int getHp(){ return health;}
}
