/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.monsters;

import game.strategy.Dumb;
import game.playerPackage.player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This the test class for Dragon. 
 * The test for effect function is valid for all monsters cards except ninja,
 * vampire, and alien. Only effect is tested as explained in Alien test.
 * @author Michael
 */
public class DragonTest {
    
    public DragonTest() {
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
     * Test of effect method, of class Dragon.
     * This test is where the enemy has 0 defense
     * The test will check the dragon does damage to the opponent.
     * The test may fail due to the random number generation done for battles
     * between cards.
     */
    @Test
    public void testEffect() {
        player owner = new player(new Dumb(),null,"Human");
        player enemy = new player(new Dumb(),null,"CPU");
        owner.field.add(new Dragon());
        owner.field.get(0).cooloff(3);
        enemy.field.add(new Golem());
        enemy.field.get(0).setDef(0);
        owner.field.get(0).setAtk(2);
        int target = 0;
        int position = 0;
        Dragon instance = (Dragon)owner.field.get(0);
        instance.effect(owner, enemy, target, position);
        assertTrue((enemy.field.get(0).getHp() < enemy.field.get(0).maxhp));
    }
    
}
