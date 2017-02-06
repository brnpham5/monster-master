package cards;

public class Spells {
	//Here's a list of all spells in the game except for a couple.
        //Not all have been implemented for this assignment.
    
        //Monster stat buffing spells. 
        //Just switch flags on monster to true.
        //Swords increases attack. Fire = +4, Regular = +2
        //Shields increases defense. Ice = +4, Regular = +2
        //Only 1 of each buff per monster. 
        //Ex. Monster can have 1 of each but not 2 regular swords.
	public FireSword fireSword = new FireSword();
	public IceShield iceShield = new IceShield();
	public Sword sword = new Sword();
	public Shield shield = new Shield();
        
        //Monster stat debuffs
        //Curse decreases monster's attack and defense by 1.
        //Weaken decreases monster's attack by 3.
        //Vulnerable decreases monster's defense by 3.
        public Curse curse = new Curse();
	public Spell weaken = new Spell("weaken");
	public Spell vulnerable = new Spell("vulnerable");
        
        
        //Healing spells.
        //Healing spells cannont heal more than max health.
        //Heal restores monster's health by 2.
        //Restore heals player's health by 2.
        //Sacrifice kills 1 monster to restores player's health by 5.
	public Heal heal = new Heal();
        public Restore restore = new Restore();
        public Sacrifice sacrifice = new Sacrifice();
        
        //Removing buffs or ailment spells.
        //Cleanse removes any ailments on user's monster.
        //Ex. Poison,Curse,Weaken,Vulnerable.
        //Antidote removes posion stack from user's monster.
        //Strip removes buffs on enemy's monster.
        //Ex. Swords and Shields
	public Spell cleanse = new Spell("cleanse");
	public Spell antidote = new Spell("antidote");
        public Strip strip = new Strip();
	
	//Damage spells
        //Fireball inflicts 3 damage to an enemy's monster
        //Lightning inflicts 2 damage to an enemy's monster
        //Flood deals 1 damage to all monsters on both fields.
	public Fireball fireball = new Fireball();
	public Lightning lightning = new Lightning();
        public Spell flood = new Spell("flood");
        
        //Ailment spells
        //Poison adds 1 stack of poison to an enemy's monster
        //Psychic allows user to an enemy's monster for current turn.
	public Spell poison = new Spell("poison");
	public Spell psychic = new Spell("psychic");
	
	//Summoning spells
        //Necromancy brings all skeletons from user's hand, deck, and grave to their field.
        //Reinforce allows user to summon 1 more time for current turn.
        //Summon sets a user's monster place to 0.
	public Spell necromancy = new Spell("necromancy");
        public Spell reinforce = new Spell("reinforce");
        public Spell summon = new Spell("summon");
        
        //Spells that deal with a players hand.
        //Steal lets user to take 1 card from enemy's hand.
        //Forget makes enemy discard 2 cards from hand.
        //Reborn brings back monster with highest attack from the user's grave to their hand.
        //Beckon does same thing as reborn except gets the monster from the user's deck.
        //Gift gets user to draw 2 cards from their deck.
	public Spell steal = new Spell("steal");
	public Forget forget = new Forget();
        public Spell reborn = new Spell("reborn");
	public Spell beckon = new Spell("beckon");
	public Gift gift = new Gift();
        
        //Killing spells.
        //Black Hole kills all monsters on both fields.
        //Doom kills enemy's monster with the lowest attack.
	public Spell blackHole = new Spell("black hole");
	public Doom doom = new Doom();
        
        //This spell allows one of the user's monster to attack 1 more time.
        public Spell charge = new Spell("charge!");
}
