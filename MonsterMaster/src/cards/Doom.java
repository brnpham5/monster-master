/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;
import game.player;

/**
 *
 * @author rajmahal
 */
public class Doom extends Spell {
    
    public Doom(){
        super("doom");
    }
    
    public void effect(player owner, player enemy, int target, int position){
        int monstertodestroy;
        monstertodestroy = enemy.field.get(0).attack;
        for (int counter= 0; counter < enemy.field.size();counter++){
         if (monstertodestroy > enemy.field.get(counter).attack){
             monstertodestroy = enemy.field.get(counter).attack;
         }
            
        }
        
        enemy.field.remove(monstertodestroy);
	owner.hand.remove(position);
	System.out.println(owner.id + " used Doom on " + owner.field.get(target).getName());
    }
    
}
