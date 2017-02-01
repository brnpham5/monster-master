package cards;

public class Monsters {
	//Here's a list of all monsters used in the demo.
	//Three monsters that are missing are those obtained with
	//the combiner spell. These are removed in this build to 
	//make gameplay less complex. Usage of the spell was hard to
	// use in single player. Others have been excluded to reduced
	//complexity.
    
    
        //Monster that heals if it does damage to a monster.
        public Vampire vampire = new Vampire();
    
        //Monsters that take no damage if failed attack
        public Alien alien = new Alien();
    
        //Monster that is immune to heals, poison, and mind control
        public Golem golem = new Golem();
        
        //Monster immune to heals and poison
        public Skeleton skeleton = new Skeleton();
        
        //Monsters with no abilities
	public Knight knight = new Knight();
	public Dwarf dwarf = new Dwarf();
	public Greebler greebler = new Greebler();
	
        //ninja has been taken
}
