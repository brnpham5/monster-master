/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

import cards.spells.Curse;
import cards.monsters.Greebler;
import game.strategy.Dumb;
import game.strategy.Offensive;
import game.playerPackage.player;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the test class for the curse spell.
 * @author Michael
 */
public class CurseTest {

    
    public CurseTest() {
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
     * Test of effect method, of class Curse.
     * It checks that the spell turns on the right flag.
     */
    @Test
    public void testEffect() {
        System.out.println("effect");
        ArrayList<Card> deck = new ArrayList();
        deck.add(new Curse());
        player owner = new player(null,new Offensive(),"Human",deck,1);
        player enemy = new player(new Dumb(),null,"CPU");
        owner.hand.add(0,new Curse());
        enemy.field.add(new Greebler());
        Curse instance = (Curse)owner.hand.get(0);
        instance.effect(owner, enemy, 0, 0);
        assertTrue(enemy.field.get(0).curse);
    }
}
