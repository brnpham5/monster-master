/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.YugiSpells;

import game.playerPackage.YugiPlayer;
import game.strategy.DumbYugi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Here is the hinotama unit test case. This tests that the card does its 
 * intended effect. The test result is valid for raimei due to similarity in their code.
 * @author Michael
 */
public class HinotamaTest {
    
    public HinotamaTest() {
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
     * Test of effect method, of class Hinotama.
     */
    @Test
    public void testEffect() {
        System.out.println("effect");
        YugiPlayer human = new YugiPlayer(new DumbYugi(),"human");
        YugiPlayer cpu = new YugiPlayer(new DumbYugi(),"cpu");
        human.hand.clear();
        human.hand.add(new Hinotama());
        human.hand.get(0).effect(human, cpu, 0, 0);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(human.getHp() == 3500);
    }
    
}
