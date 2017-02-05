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
public class Ninja extends Monster{
    
    public Ninja(){
        super("ninja",4,1,1,3);
    }
    
    public void effect(player own, player enem,int targ,int posit){
            if(targ != -1){
		int dmg = fight(this,enem.field.get(targ));
		System.out.println(name+" attacks "+enem.field.get(targ).getName());
		if(dmg < 0){
                    System.out.println("Ninja failed to do damage");
		}
		else if(dmg > 0){
            
                    enem.field.get(targ).setHp(0);
                    enem.field.get(targ).re
                    System.out.println(enem.field.get(targ).getName() + " dies");
            
        }
                
     }
    }   
}
