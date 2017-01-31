package cards;

public class Monsters {
	//Here's a list of all monsters used in the demo.
	//Three monsters that are missing are those obtained with
	//the combiner spell. These are removed in this build to 
	//make gameplay less complex. Usage of the spell was hard to
	// use in single player. Others have been excluded to reduced
	//complexity.
    
    
        //Monster that heals if it does damage to a monster.
        public Monster vampire = new Monster("vampire",4,3,1,5);
    
        //Monsters that take no damage if failed attack
        public Alien alien = new Alien();
    
        //Monster that is immune to heals, poison, and mind control
        public Monster golem = new Monster("golem",4,6,2,5);
        
        //Monster immune to heals and poison
        public Monster skeleton = new Monster("skeleton",3,2,1,3);
        
        //Monsters with no abilities
	public Knight knight = new Knight();
	public Monster dwarf = new Monster("dwarf",5,5,2,5);
	public Monster greebler = new Monster("greebler",4,3,1,3);
	
}
