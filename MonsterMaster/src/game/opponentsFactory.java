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
    
    public YugiPlayer joey1(){
        //Populate Deck
        deck.add(new Abaki());
        deck.add(new Prisman());
        deck.add(new MrBones());
        deck.add(new FaithBird());
        deck.add(new MasterNinja());
        deck.add(new DarkMagician());
        deck.add(new LuminousSoldier());
        deck.add(new Raimei());
        deck.add(new SoulShield());
        deck.add(new PhantomGryphon());
        

        //Return player
        //YugiStrategy strat, String name,ArrayList<Card> Cards,int draws
        return new YugiPlayer(offense, "Joey", deck, 5);
    }
    
    public YugiPlayer bakura2(){
        //Populate Deck
        deck.add(new LusterDragon());
        deck.add(new Megazowler());
        deck.add(new Yamadron());
        deck.add(new Griffore());
        deck.add(new Tyhone());
        deck.add(new GarneciaElefantis());
        deck.add(new LuminousSoldier());
        deck.add(new Salamandra());
        deck.add(new SoulShield());
        deck.add(new Wilmee());
        

        //Return player
        //YugiStrategy strat, String name,ArrayList<Card> Cards,int draws
        return new YugiPlayer(offense, "Bakura", deck, 5);
    }
    
    public YugiPlayer yuki2(){
        //Populate Deck
        deck.add(new Gagagigo());
        deck.add(new FaithBird());
        deck.add(new CyberFalcon());
        deck.add(new Griffore());
        deck.add(new Fireyarou());
        deck.add(new GaiaTheFierceKnight());
        deck.add(new GadgetSoldier());
        deck.add(new Salamandra());
        deck.add(new Hinotama());
        deck.add(new AxeRaider());
        

        //Return player
        //YugiStrategy strat, String name,ArrayList<Card> Cards,int draws
        return new YugiPlayer(offense, "Yuki", deck, 5);
    }
    
    public YugiPlayer jack2(){
        //Populate Deck
        deck.add(new AllyMind());
        deck.add(new BioMage());
        deck.add(new Fireyarou());
        deck.add(new AncientElf());
        deck.add(new Hibikime());
        deck.add(new BigKoala());
        deck.add(new AllyofJusticeClausolas());
        deck.add(new Raimei());
        deck.add(new SoulShield());
        deck.add(new Blocker());
        

        //Return player
        //YugiStrategy strat, String name,ArrayList<Card> Cards,int draws
        return new YugiPlayer(offense, "Valentine", deck, 5);
    }
    
    public YugiPlayer tristan2(){
        //Populate Deck
        deck.add(new Kurama());
        deck.add(new DarkElf());
        deck.add(new NinKenDog());
        deck.add(new MrBones());
        deck.add(new HarpieLady());
        deck.add(new Hyozanryu());
        deck.add(new Megazowler());
        deck.add(new Raimei());
        deck.add(new TowerShield());
        deck.add(new Leogun());
        

        //Return player
        //YugiStrategy strat, String name,ArrayList<Card> Cards,int draws
        return new YugiPlayer(offense, "Tristan", deck, 5);
    }
    
    public YugiPlayer fudo3(){
        //Populate Deck
        deck.add(new Peacock());
        deck.add(new SkyDragon());
        deck.add(new PhantomGryphon());
        deck.add(new Souleater());
        deck.add(new RoboticKnight());
        deck.add(new Rabidragon());
        deck.add(new Leogun());
        deck.add(new TowerShield());
        deck.add(new SoulShield());
        deck.add(new RyuRan());
        

        //Return player
        //YugiStrategy strat, String name,ArrayList<Card> Cards,int draws
        return new YugiPlayer(offense, "Fudo", deck, 5);
    }
    
    public YugiPlayer mokuba3(){
        //Populate Deck
        deck.add(new AmphibianBeast());
        deck.add(new AllyMind());
        deck.add(new Gagagigo());
        deck.add(new Aitsu());
        deck.add(new Garoozis());
        deck.add(new CosmoQueen());
        deck.add(new MrVolcano());
        deck.add(new Salamandra());
        deck.add(new Raimei());
        deck.add(new DrakeValleyMaster());
        

        //Return player
        //YugiStrategy strat, String name,ArrayList<Card> Cards,int draws
        return new YugiPlayer(offense, "Mokuba", deck, 5);
    }
    
    public YugiPlayer duke3(){
        //Populate Deck
        deck.add(new SkyDragon());
        deck.add(new DarkElf());
        deck.add(new HarpieLady());
        deck.add(new Leogun());
        deck.add(new EmpressMantis());
        deck.add(new DarkMagician());
        deck.add(new Seiyaryu());
        deck.add(new Raimei());
        deck.add(new TowerShield());
        deck.add(new DrakeValleyMaster());
        

        //Return player
        //YugiStrategy strat, String name,ArrayList<Card> Cards,int draws
        return new YugiPlayer(offense, "Duke", deck, 5);
    }
    
    public YugiPlayer drow4(){
        //Populate Deck
        deck.add(new GadgetSoldier());
        deck.add(new Garoozis());
        deck.add(new Vestri());
        deck.add(new Yamadron());
        deck.add(new Blocker());
        deck.add(new Zoa());
        deck.add(new TurtleBird());
        deck.add(new TowerShield());
        deck.add(new SoulShield());
        deck.add(new MonsterKnight());
        

        //Return player
        //YugiStrategy strat, String name,ArrayList<Card> Cards,int draws
        return new YugiPlayer(offense, "Drow", deck, 5);
    }
    
    public YugiPlayer dartz4(){
        //Populate Deck
        deck.add(new DrakeValleyMaster());
        deck.add(new Tyhone());
        deck.add(new FirewingPegasus());
        deck.add(new FaithBird());
        deck.add(new Takuhee());
        deck.add(new DarkMagician());
        deck.add(new GarneciaElefantis());
        deck.add(new Raimei());
        deck.add(new SoulShield());
        deck.add(new GaiaTheFierceKnight());
        

        //Return player
        //YugiStrategy strat, String name,ArrayList<Card> Cards,int draws
        return new YugiPlayer(offense, "Dartz", deck, 5);
    }
    
    public YugiPlayer phoenix4(){
        //Populate Deck
        deck.add(new Wingweaver());
        deck.add(new Swordstalker());
        deck.add(new MasterAlien());
        deck.add(new Leogun());
        deck.add(new Kurama());
        deck.add(new Sengenjin());
        deck.add(new RedEyesBD());
        deck.add(new Hinotama());
        deck.add(new SoulShield());
        deck.add(new Seiyaryu());
        

        //Return player
        //YugiStrategy strat, String name,ArrayList<Card> Cards,int draws
        return new YugiPlayer(offense, "Phoenix", deck, 5);
    }
    
    public YugiPlayer kaiba5(){
        //Populate Deck
        deck.add(new BlueEyesWD());
        deck.add(new LusterDragon());
        deck.add(new FairyDragon());
        deck.add(new SkyDragon());
        deck.add(new Yamadron());
        deck.add(new BlueEyesWD());
        deck.add(new Megazowler());
        deck.add(new Raimei());
        deck.add(new NephthysCurse());
        deck.add(new BlueEyesWD());
        

        //Return player
        //YugiStrategy strat, String name,ArrayList<Card> Cards,int draws
        return new YugiPlayer(offense, "Kaiba", deck, 5);
    }
    
}
