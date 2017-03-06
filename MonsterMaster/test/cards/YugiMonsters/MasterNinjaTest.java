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
 * Here is the unit test case for the yugioh ninja card. 
 * The activation of the ability and the ability itself are tested.
 * @author Michael
 */
public class MasterNinjaTest {
    
    public MasterNinjaTest() {
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
     * Test of effect method, of class MasterNinja. 
     */
    @Test
    public void testEffect() {
        System.out.println("effect");
        YugiPlayer human = new YugiPlayer(new DumbYugi(),"human");
        YugiPlayer cpu = new YugiPlayer(new DumbYugi(),"cpu");
        cpu.field.addMon(new Greeble());
        cpu.field.getMon(0).attackPos = false;
        cpu.field.getMon(0).flipped = false;
        int target = 0;
        int position = 0;
        MasterNinja instance = new MasterNinja();
        instance.effect(human, cpu, target, position);
        assertTrue(cpu.field.isMonEmpty() && cpu.grave.get(0).getName().equals("Greeble"));
    }

    /**
     * Test of attack method, of class MasterNinja.
     */
    @Test
    public void testAttack() {
        System.out.println("attack");
        YugiPlayer human = new YugiPlayer(new DumbYugi(),"human");
        YugiPlayer cpu = new YugiPlayer(new DumbYugi(),"cpu");
        human.field.addMon(new MasterNinja());
        human.field.getMon(0).attackPos = true;
        human.field.getMon(0).flipped = true;
        cpu.field.addMon(new Greeble());
        cpu.field.getMon(0).attackPos = false;
        cpu.field.getMon(0).flipped = false;
        human.field.getMon(0).attack(human, cpu, 0, 0);
        assertTrue(cpu.field.isMonEmpty());
    }
    
}
