package cards;

//Below are the code needed for a monster card from
//monster masters. This does not completely mimic the 
//functionality of game's monster cards, but have enough
//to be similar to the game.
public class Monster implements Card {
	
	//Attributes that a monster card has in game.
	//The name of the monster.
	private String name;
	
	
	//The attack value of the monster.
	//Attack value is the damage the monster does to opposing player.
	//Attack value is maximum amount of damage that monsters can do to
	//another monster. Used in damage calculation.
	private int attack;
	
	
	//The defense value of the monster.
	//Defense value is the maximum amount damage the monster does to its
	//attacker. Used in damage calculation.
	private int defense;
	
	
	//The life points that the monster has.
	//This value decreases depending on the out comes of battles.
	//This can be increase with the restore spell.
	//If this monster is vampire then it can gain health if it does damage.
	private int health;
	
	
	//This is the max amount of life a monster can have.
	//Monsters cannot have more life than this. If they are healed for more
	//than this value then their health equals this.
	public int maxhp;
	
	
	//This is the how long the monster cannot attack after being summoned.
	//When the placed value is 0 then the monster can attack. The placed
	//value will decrease by 1 at the end of the user's turn.
	private int cooldown;
	private int placed;
	
	
	//These are flags for the different spells used on the monster
	//These are switched to true when spells are used on them.
	public boolean shield = false;
	public boolean sword = false;
	public boolean curse = false;
	
	
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
		return (attack + modifier); }
	
	public void setDef(int def){ defense = def;}
	
	public int getDef(){
		int modifier = 0; 
		if(shield){modifier += 2;}
		if(curse){modifier -= 1;}
		return (defense + modifier); }
	
	public void summoned(){ placed = cooldown;} 
	
	public void cooloff(int cool){
		if(placed > 0){
		placed -= cool;}
		}
	
	public int getPlaced(){return placed;}
	
	public void setHp(int hp){
		if((hp + health) > maxhp){ health = hp;}
		else {health -= hp;}
	}
	
	public int getHp(){ return health;}
}
