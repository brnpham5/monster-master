/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.YugiMonsters;

import game.playerPackage.YugiPlayer;

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
        enemy.grave.add(enemy.field.getMon(target));
        enemy.field.removeMon(target);
    }
    
    
    
    @Override
    //
    public void attack(YugiPlayer owner, YugiPlayer enemy, int target, int position) {
        Mon opponent = enemy.field.getMon(target);
        if(target == -1){enemy.setHp(getAtk());}
        else if(!opponent.flipped){effect(owner,enemy,target,position);}
        else{
            if(attack > enemy.field.getMon(target).getStat()){
                if(opponent.attackPos){
                    opponent.deathEffect(owner, enemy, position);
                    enemy.grave.add(opponent);
                    enemy.field.removeMon(target);
                }
                else {
                    enemy.setHp(attack - opponent.getStat());
                    opponent.deathEffect(owner, enemy, target);
                    enemy.grave.add(opponent);
                    enemy.field.removeMon(target);
                }
            }
            else if(attack < opponent.getStat()){
                    if(opponent.attackPos){
                        owner.setHp(opponent.getStat()-attack);
                        owner.field.getMon(position).deathEffect(owner, enemy, position);
                        owner.grave.add(this);
                        owner.field.removeMon(position);
                    }
                else {owner.setHp(opponent.getStat()-attack);}
            }
            else {
                if(opponent.attackPos){
                    opponent.deathEffect(owner, enemy, target);
                    enemy.grave.add(opponent);
                    enemy.field.removeMon(target);
                    owner.field.getMon(position).deathEffect(owner, enemy, position);
                    owner.grave.add(this);
                    owner.field.removeMon(position);
                }
                else{opponent.flipped = true;}
            }
        }
    }
}
