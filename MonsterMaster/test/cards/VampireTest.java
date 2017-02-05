/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

import game.Dumb;
import game.player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the test class for the vampire monster class.
 * The effect function is tested here.
 * @author Michael
 */
public class VampireTest {
    
    public VampireTest() {
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
     * Test of effect method, of class Vampire.
     * Test checks the vampire's effect function.
     * It will verify that the monster is healed when it does damage.
     * Test may fail due to random number generation of monster fighting. 
     */
    @Test
    public void testEffect() {
        System.out.println("effect");
        player owner = new player(new Dumb(),null,"Human");
        player enemy = new player(new Dumb(),null,"CPU");
        owner.field.add(new Vampire());
        owner.field.get(0).placed = 0;
        enemy.field.add(new Golem());
        enemy.field.get(0).setDef(0);
        owner.field.get(0).setHp(1);
        int target = 0;
        int position = 0;
        Vampire instance = (Vampire)owner.field.get(0);
        System.out.println(instance.getHp() + " "+instance.maxhp);
        instance.effect(owner, enemy, target, position);
        System.out.println(instance.getHp() + " "+instance.maxhp);
        assertTrue(instance.getHp() == instance.maxhp);
    }
    
}
