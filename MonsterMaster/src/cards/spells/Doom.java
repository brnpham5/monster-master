/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.spells;
import cards.Spell;
import game.playerPackage.player;

/*
 *Doom selects the opponents monster with the lowest attack and removes/destroys it from the field
 */

public class Doom extends Spell {
    
    public Doom(){
        super("doom");
    }
    
    public void effect(player owner, player enemy, int target, int position){
        int monstertodestroy; // int to hold the position of lowest attack monster
        monstertodestroy = enemy.field.get(0).getAtk(); //sets value to first spot field
        for (int counter= 0; counter < enemy.field.size();counter++){
         if (monstertodestroy > enemy.field.get(counter).getAtk()){
             monstertodestroy = enemy.field.get(counter).getAtk();//iterates through array triest to find the position of lowest attack monster
         }
        }

	owner.hand.remove(position); // removes card
	System.out.println(owner.id + " used Doom on " + enemy.field.get(monstertodestroy).getName()); // announces removal of monster
        enemy.field.remove(monstertodestroy);//removes monster at position with lowest attack monster
    }
    
}
