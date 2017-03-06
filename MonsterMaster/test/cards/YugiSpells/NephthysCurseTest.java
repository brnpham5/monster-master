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
 *
 * @author Michael
 */
public class NephthysCurseTest {
    
    public NephthysCurseTest() {
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
     * Test of effect method, of class NephthysCurse.
     */
    @Test
    public void testEffect() {
        System.out.println("effect");
        YugiPlayer human = new YugiPlayer(new DumbYugi(),"human");
        YugiPlayer cpu = new YugiPlayer(new DumbYugi(),"cpu");
        cpu.field.addMon(new MonsterKnight());
        human.hand.clear();
        human.hand.add(new NephthysCurse());
        human.hand.get(0).effect(human, cpu, 0, 0);
        // TODO review the generated test code and remove the default call to fail.
        Mon card = cpu.field.getMon(0);
        assertTrue(card.atkMod == -800 && card.defMod == -800);
    }
    
}
