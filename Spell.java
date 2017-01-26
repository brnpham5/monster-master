package cards;

public class Spell implements Card {
	
	private String name;
	
	public Spell(String id){
		name = id;
	}

	@Override
	public String getType() { return "spell";}

	@Override
	public String getName() { return name; }
	

}
