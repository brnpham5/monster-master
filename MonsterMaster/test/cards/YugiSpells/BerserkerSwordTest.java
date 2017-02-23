/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.YugiSpells;

import cards.YugiMonsters.Mon;
import cards.YugiMonsters.MonsterKnight;
import game.playerPackage.YugiPlayer;
import game.strategy.DumbYugi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Here is the unit test case for the BerserkerSword spell card.
 * @author Michael
 */
public class BerserkerSwordTest {
    
    public BerserkerSwordTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of effect method, of class BerserkerSword.
     */
    @Test
    public void testEffect() {
        System.out.println("effect");
        YugiPlayer human = new YugiPlayer(new DumbYugi(),"human");
        YugiPlayer cpu = new YugiPlayer(new DumbYugi(),"cpu");
        human.field.addMon(new MonsterKnight());
        human.hand.clear();
        human.hand.add(new BerserkerSword());
        human.hand.get(0).effect(human, cpu, 0, 0);
        Mon card = human.field.getMon(0);
        assertTrue(card.defMod == -400 && card.atkMod == 500);
    }

    /**
     * Test of removedEffect method, of class BerserkerSword.
     */
    @Test
    public void testRemovedEffect() {
        System.out.println("removedEffect");
        YugiPlayer human = new YugiPlayer(new DumbYugi(),"human");
        YugiPlayer cpu = new YugiPlayer(new DumbYugi(),"cpu");
        human.field.addMon(new MonsterKnight());
        human.hand.clear();
        human.hand.add(new SoulShield());
        human.hand.get(0).effect(human, cpu, 0, 0);
        Mon card = human.field.getMon(0);
        human.field.getMagic(0).removedEffect(human, cpu, 0, 0);
        assertTrue(card.defMod == 0 && card.atkMod == 0);
    }
    
}
