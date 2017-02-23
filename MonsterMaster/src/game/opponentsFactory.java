/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import cards.Card;
import game.playerPackage.YugiPlayer;
import java.util.ArrayList;
import cards.YugiMonsters.*;
import cards.YugiSpells.*;
import game.strategy.*;

/**
 *
 * @author brnpham
 */
public class opponentsFactory {
    ArrayList<Card> deck = new ArrayList();
    OffensiveYugi offense = new OffensiveYugi();
    DumbYugi dumb = new DumbYugi();
    
    public YugiPlayer kaiba1(){
        //Populate Deck
        deck.add(new AxeRaider());
        deck.add(new AxeRaider());
        
        //Return player
        //YugiStrategy strat, String name,ArrayList<Card> Cards,int draws
        return new YugiPlayer(offense, "kaiba1", deck, 5);
    }
    
    public YugiPlayer weevil1(){
        //Populate Deck
        deck.add(new AxeRaider());
        deck.add(new AxeRaider());
        
        //Return player
        //YugiStrategy strat, String name,ArrayList<Card> Cards,int draws
        return new YugiPlayer(offense, "weevil1", deck, 5);
    }
    
    public YugiPlayer valentine1(){
        //Populate Deck
        deck.add(new Greeble());
        deck.add(new DarkElf());
        deck.add(new Fireyarou());
        deck.add(new FaithBird());
        deck.add(new CyberFalcon());
        deck.add(new DarkMagician());
        deck.add(new LuminousSoldier());
        deck.add(new Raimei());
        deck.add(new SoulShield());
        deck.add(new MonsterKnight());
        

        //Return player
        //YugiStrategy strat, String name,ArrayList<Card> Cards,int draws
        return new YugiPlayer(offense, "Valentine", deck, 5);
    }
    
    
}
