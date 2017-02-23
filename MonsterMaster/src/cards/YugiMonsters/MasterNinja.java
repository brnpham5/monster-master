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
        else if(!opponent.flipped){
            System.out.println(name +" killed "+ opponent.getName());
            effect(owner,enemy,target,position);}
        else{
            System.out.println(name +" attacks "+ enemy.id);
            if(attack > enemy.field.getMon(target).getStat()){
                if(!opponent.attackPos){
                    System.out.println(name +" killed "+ opponent.getName());
                    opponent.deathEffect(owner, enemy, position);
                    enemy.grave.add(opponent);
                    enemy.field.removeMon(target);
                }
                else {
                    System.out.println(name +" killed "+ opponent.getName()+
                                       " and deals "+ (attack - opponent.getStat()) + " damage");
                    enemy.setHp(attack - opponent.getStat());
                    opponent.deathEffect(owner, enemy, target);
                    enemy.grave.add(opponent);
                    enemy.field.removeMon(target);
                }
            }
            else if(attack < opponent.getStat()){
                    if(opponent.attackPos){
                        System.out.println(name +" is killed and "+ owner.id +
                                           " takes "+ (opponent.getStat()-attack) + " damage.");
                        owner.setHp(opponent.getStat()-attack);
                        owner.field.getMon(position).deathEffect(owner, enemy, position);
                        owner.grave.add(this);
                        owner.field.removeMon(position);
                    }
                else {
                        System.out.println(owner.id +" takes "+ (opponent.getStat()-attack) +" damage.");
                        owner.setHp(opponent.getStat()-attack);}
            }
            else {
                if(opponent.attackPos){
                    System.out.println(name+" and "+ opponent.getName()+" died." );
                    opponent.deathEffect(owner, enemy, target);
                    enemy.grave.add(opponent);
                    enemy.field.removeMon(target);
                    owner.field.getMon(position).deathEffect(owner, enemy, position);
                    owner.grave.add(this);
                    owner.field.removeMon(position);
                }
            }
        }
    }
}
