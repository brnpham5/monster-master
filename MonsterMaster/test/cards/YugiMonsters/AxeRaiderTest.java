/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.YugiMonsters;

import cards.YugiSpells.SoulShield;
import game.playerPackage.YugiPlayer;
import game.strategy.DumbYugi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the unit test for axe raider a normal monster. The test results in here
 * are valid for all normal category mon card classes. 
 * @author Michael
 */
public class AxeRaiderTest {
    
    public AxeRaiderTest() {
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
     * This test checks that card does damage to enemy player if the enemy monster
     * field is empty.
     */
    @Test
    public void testAttackEmpty() {
        YugiPlayer human = new YugiPlayer(new DumbYugi(),"human");
        YugiPlayer cpu = new YugiPlayer(new DumbYugi(),"cpu");
        human.hand.clear();
        human.field.addMon(new AxeRaider());
        human.field.getMon(0).attackPos = true;
        human.field.getMon(0).flipped = true;
        human.field.getMon(0).attack(human, cpu, -1, 0);
        assertTrue(cpu.getHp() < 4000);
    }
    
    /**
     * This test checks that card kills enemy monster if that monster is weaker.
     */
    @Test
    public void testAttackStrongerAtk() {
        YugiPlayer human = new YugiPlayer(new DumbYugi(),"human");
        YugiPlayer cpu = new YugiPlayer(new DumbYugi(),"cpu");
        human.hand.clear();
        human.field.addMon(new AxeRaider());
        human.field.getMon(0).attackPos = true;
        human.field.getMon(0).flipped = true;
        cpu.field.addMon(new Greeble());
        cpu.field.getMon(0).attackPos = true;
        cpu.field.getMon(0).flipped = true;
        human.field.getMon(0).attack(human, cpu, 0, 0);
        assertTrue(cpu.field.isMonEmpty() && cpu.getHp() < 4000);
    }
    
    /**
     * This test checks that card kills enemy monster if that monster is weaker.
     */
    @Test
    public void testAttackStrongerDef() {
        YugiPlayer human = new YugiPlayer(new DumbYugi(),"human");
        YugiPlayer cpu = new YugiPlayer(new DumbYugi(),"cpu");
        human.hand.clear();
        human.field.addMon(new AxeRaider());
        human.field.getMon(0).attackPos = true;
        human.field.getMon(0).flipped = true;
        cpu.field.addMon(new Greeble());
        cpu.field.getMon(0).attackPos = false;
        cpu.field.getMon(0).flipped = true;
        human.field.getMon(0).attack(human, cpu, 0, 0);
        assertTrue(cpu.field.isMonEmpty() && cpu.getHp() == 4000);
    }
    
    /**
     * This test checks that both attacking card and attacked card are removed from
     * field if they are in attack position and equal attack.
     */
    @Test
    public void testAttackEqualAtk() {
        YugiPlayer human = new YugiPlayer(new DumbYugi(),"human");
        YugiPlayer cpu = new YugiPlayer(new DumbYugi(),"cpu");
        human.hand.clear();
        human.field.addMon(new AxeRaider());
        human.field.getMon(0).attackPos = true;
        human.field.getMon(0).flipped = true;
        cpu.field.addMon(new AxeRaider());
        cpu.field.getMon(0).attackPos = true;
        cpu.field.getMon(0).flipped = true;
        human.field.getMon(0).attack(human, cpu, 0, 0);
        assertTrue(cpu.field.isMonEmpty() && human.field.isMonEmpty());
    }
    
    /**
     * This test checks that card cannot kill a monster if the attacker's attack value
     * equals the victim's defense value.
     */
    @Test
    public void testAttackEqualDefense() {
        YugiPlayer human = new YugiPlayer(new DumbYugi(),"human");
        YugiPlayer cpu = new YugiPlayer(new DumbYugi(),"cpu");
        human.hand.clear();
        human.field.addMon(new AxeRaider());
        human.field.getMon(0).attackPos = true;
        human.field.getMon(0).flipped = true;
        cpu.field.addMon(new Greeble());
        cpu.field.getMon(0).attackPos = false;
        cpu.field.getMon(0).defMod = 1400;
        cpu.field.getMon(0).flipped = true;
        human.field.getMon(0).attack(human, cpu, 0, 0);
        assertTrue(cpu.field.monSize() == 1);
    }
    
     /**
     * This test checks that card is killed if it attacks a monster in attack position
     * with higher attack value.
     */
    @Test
    public void testAttackLessAtk() {
        YugiPlayer human = new YugiPlayer(new DumbYugi(),"human");
        YugiPlayer cpu = new YugiPlayer(new DumbYugi(),"cpu");
        human.hand.clear();
        human.field.addMon(new AxeRaider());
        human.field.getMon(0).attackPos = true;
        human.field.getMon(0).flipped = true;
        cpu.field.addMon(new Greeble());
        cpu.field.getMon(0).attackPos = true;
        cpu.field.getMon(0).atkMod = 1400;
        cpu.field.getMon(0).flipped = true;
        human.field.getMon(0).attack(human, cpu, 0, 0);
        assertTrue(human.field.isMonEmpty() && human.getHp() < 4000);
    }
    
     /**
     * This test checks that if the attacking card has less attack value than 
     * the defending monster's defense value.
     */
    @Test
    public void testAttackLessDef() {
        YugiPlayer human = new YugiPlayer(new DumbYugi(),"human");
        YugiPlayer cpu = new YugiPlayer(new DumbYugi(),"cpu");
        human.hand.clear();
        human.field.addMon(new AxeRaider());
        human.field.getMon(0).attackPos = true;
        human.field.getMon(0).flipped = true;
        cpu.field.addMon(new Greeble());
        cpu.field.getMon(0).attackPos = false;
        cpu.field.getMon(0).defMod = 1500;
        cpu.field.getMon(0).flipped = true;
        human.field.getMon(0).attack(human, cpu, 0, 0);
        assertTrue(!cpu.field.isMonEmpty() && human.getHp() < 4000);
    }
    
    /**
     * This test checks that monster does tell the owner to remove spells equipped 
     * to monster.
     */
    @Test
    public void testDeath(){
        YugiPlayer human = new YugiPlayer(new DumbYugi(),"human");
        YugiPlayer cpu = new YugiPlayer(new DumbYugi(),"cpu");
        cpu.field.addMon(new AxeRaider());
        cpu.field.getMon(0).attackPos = false;
        cpu.field.getMon(0).flipped = true;
        cpu.hand.clear();
        cpu.hand.add(new SoulShield());
        cpu.hand.get(0).effect(cpu, human, 0, 0);
        human.field.addMon(new BlueEyesWD());
        human.field.getMon(0).attackPos = true;
        human.field.getMon(0).flipped = true;
        human.turn(cpu, 2);
        assertTrue(cpu.field.isMagicEmpty());
    }
    
}
