/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.YugiMonsters;

import game.YugiPlayer;

/**
 * This is the ninja card from monster master translated to yugioh card format.
 * The card still retains its instant killing property but is now changed to new
 * activation terms.
 * @author Michael
 */
public class MasterNinja extends Mon{
    public MasterNinja(){
        super("Master Ninja",4,1400,100,"e",18,1);
    }
    
    @Override
    public void effect(YugiPlayer owner, YugiPlayer enemy, int target, int position){
        enemy.grave.add(enemy.field.get(target));
        enemy.field.remove(target);
    }
    
    
    
    @Override
    //
    public void attack(YugiPlayer owner, YugiPlayer enemy, int target, int position) {
        if(target == -1){enemy.setHp(getAtk());}
        else if(!enemy.field.get(target).flipped){effect(owner,enemy,target,position);}
        else{
            if(attack > enemy.field.get(target).getStat()){
                if(enemy.field.get(target).attackPos){
                    enemy.setHp(attack - enemy.field.get(target).getStat());
                    enemy.field.get(target).deathEffect(owner, enemy, target);
                    enemy.grave.add(enemy.field.get(target));
                    enemy.field.remove(target);
                }
                else {
                    enemy.field.get(target).deathEffect(owner, enemy, position);
                    enemy.grave.add(enemy.field.get(target));
                    enemy.field.remove(target);
                }
            }
            else if(attack < enemy.field.get(target).getStat()){
                    if(enemy.field.get(target).attackPos){
                        owner.setHp(enemy.field.get(target).getStat()-attack);
                        owner.field.get(position).deathEffect(owner, enemy, position);
                        owner.grave.add(this);
                        owner.field.remove(position);
                    }
                else {owner.setHp(enemy.field.get(target).getStat()-attack);}
            }
            else {
                if(enemy.field.get(target).attackPos){
                    enemy.field.get(target).deathEffect(owner, enemy, target);
                    enemy.grave.add(enemy.field.get(target));
                    enemy.field.remove(target);
                    owner.field.get(position).deathEffect(owner, enemy, position);
                    owner.grave.add(this);
                    owner.field.remove(position);
                }
                else{enemy.field.get(target).flipped = true;}
            }
        }
    }
}
