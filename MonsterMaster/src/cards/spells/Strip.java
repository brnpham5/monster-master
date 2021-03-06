/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.spells;
import cards.Spell;
import game.playerPackage.player;

/*
 *Removes helpful effects from an enemy monster
 *
 */
public class Strip extends Spell{
    
    public Strip(){
        super("strip");
    }
    
    
    public void effect(player owner, player enemy, int target, int position){
        enemy.field.get(target).sword = false;//remove shield
        enemy.field.get(target).shield = false;//removes sword
        enemy.field.get(target).firesword = false;//removes firesword
        enemy.field.get(target).iceshield = false;//removes iceshield
	owner.hand.remove(position);//removes card from hand
	System.out.println(owner.id + " used Strip on " + owner.field.get(target).getName());//anounces use of card
    }
    
}
