/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

import cards.monsters.Alien;
import cards.monsters.Golem;
import game.strategy.Dumb;
import game.playerPackage.player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Class for Alien card.
 * Only the effect is tested since that only thing special about it besides
 * its stats. Stats do not need to be tested as they are set by constructor
 * and are not touched by anyone unless setters are used.
 * @author Michael
 */
public class AlienTest {
    
    public AlienTest() {
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
     * Test of effect method, of class Alien.
     * This test is where the enemy has 0 defense
     * The test will check the alien does damage to the opponent.
     * The test may fail due to the random number generation done for battles
     * between cards.
     */
    @Test
    public void testAttack() {
        System.out.println("effect");
        player owner = new player(new Dumb(),null,"Human");
        player enemy = new player(new Dumb(),null,"CPU");
        owner.field.add(new Alien());
        owner.field.get(0).placed = 0;
        enemy.field.add(new Golem());
        enemy.field.get(0).setDef(0);
        int target = 0;
        int position = 0;
        Alien instance = (Alien)owner.field.get(0);
        instance.effect(owner, enemy, target, position);
        assertTrue(enemy.field.get(0).getHp() < enemy.field.get(0).maxhp);
    }
    
    
    
    /**
     * Test of effect method, of class Alien.
     * This test is where the alien has 0 attack
     * The test will check that the alien takes 0 damage when it fails it attack.
     */
    @Test
    public void testEffect() {
        System.out.println("effect");
        player owner = new player(new Dumb(),null,"Human");
        player enemy = new player(new Dumb(),null,"CPU");
        owner.field.add(new Alien());
        owner.field.get(0).placed = 0;
        enemy.field.add(new Golem());
        owner.field.get(0).setAtk(0);
        int target = 0;
        int position = 0;
        Alien instance = new Alien();
        instance.effect(owner, enemy, target, position);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(owner.field.get(0).getHp() == enemy.field.get(0).maxhp);
    }
}
