/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcases;

import cards.Monsters;
import cards.Spells;
import game.strategy.Dumb;
import game.strategy.Offensive;
import game.playerPackage.player;

/**
 *
 * @author brnpham
 */
public class tester_restoreSpells {
    public static void main(String[] args) throws InterruptedException{
        Monsters group = new Monsters();
	Spells powers = new Spells();
	String choice = "";
        
        Dumb planA = null;
	Offensive planB = null;
        
        Offensive comp = new Offensive();
        
        player human = new player(planA,planB,"human");
	player cpu = new player(null,comp,"computer");
        
        
        
    }
}
