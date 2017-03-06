/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.YugiMonsters;

import game.playerPackage.YugiPlayer;
import game.strategy.DumbYugi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the unit test case for master alien yugioh card.
 * @author Michael
 */
public class MasterAlienTest {
    
    public MasterAlienTest() {
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
     * This the unit test case for master alien attack function.
     * This makes sure that the owner takes no damage when the defending monster
     * has higher defense and is in defense mode.
     */
    @Test
    public void testAttackLessDefense() {
        YugiPlayer human = new YugiPlayer(new DumbYugi(),"human");
        YugiPlayer cpu = new YugiPlayer(new DumbYugi(),"cpu");
        human.hand.clear();
        human.field.addMon(new MasterAlien());
        human.field.getMon(0).attackPos = true;
        human.field.getMon(0).flipped = true;
        cpu.field.addMon(new Greeble());
        cpu.field.getMon(0).attackPos = false;
        cpu.field.getMon(0).defMod = 2500;
        cpu.field.getMon(0).flipped = true;
        human.field.getMon(0).attack(human, cpu, 0, 0);
        assertTrue(!cpu.field.isMonEmpty() && human.getHp() == 4000);
    }
    
    
    /**
     * This the unit test case for master alien attack function.
     * This makes sure that the owner takes no damage when the defending monster
     * has higher attack and is in attack mode.
     */
    @Test
    public void testAttackLessAttack() {
        YugiPlayer human = new YugiPlayer(new DumbYugi(),"human");
        YugiPlayer cpu = new YugiPlayer(new DumbYugi(),"cpu");
        human.hand.clear();
        human.field.addMon(new MasterAlien());
        human.field.getMon(0).attackPos = true;
        human.field.getMon(0).flipped = true;
        cpu.field.addMon(new Greeble());
        cpu.field.getMon(0).attackPos = true;
        cpu.field.getMon(0).atkMod = 2500;
        cpu.field.getMon(0).flipped = true;
        human.field.getMon(0).attack(human, cpu, 0, 0);
        assertTrue(!cpu.field.isMonEmpty() && human.getHp() == 4000);
    }
}
