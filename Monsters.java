package cards;

public class Monsters {
	//Here's a list of all monsters used in the demo.
	//Three monsters that are missing are those obtained with
	//the combiner spell. These are removed in this build to 
	//make gameplay less complex. Usage of the spell was hard to
	// use in single player. Others have been excluded to reduced
	//complexity.
	public Monster knight = new Monster("knight",6,4,2,4);
	public Monster alien = new Monster("alien",5,4,2,5);
	public Monster golem = new Monster("golem",4,6,2,5);
	public Monster dwarf = new Monster("dwarf",5,5,2,5);
	public Monster vampire = new Monster("vampire",4,3,1,5);
	public Monster greebler = new Monster("greebler",4,3,1,3);
	public Monster skeleton = new Monster("skeleton",3,2,1,3);
}
