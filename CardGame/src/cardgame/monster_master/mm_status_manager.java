/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame.monster_master;

import java.util.ArrayList;

/**
 * Contains all the status effects of the monster master game
 * @author brnpham
 */
public class mm_status_manager {
    public ArrayList <String> status = new ArrayList();
    
    mm_status_manager(){
        status.add("Psychic");
        status.add("Poison");
        status.add("Reaper");
        status.add("Ice Shield");
        status.add("Shield");
        status.add("Fire Sword");
        status.add("Sword");
    }
}
