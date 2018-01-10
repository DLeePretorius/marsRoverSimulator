/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marsroverSimulation;

import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;

/**
 *
 * @author Diane-Lee
 */
public class RoverTest {

    private static Plateau plat;
    private static Rover instance;

    /**
     * Initialise the test variables before the test
     */
    @BeforeClass
    public static void initialiseTestVariables() {
        plat = new Plateau(new Point(8, 8));
        instance = new Rover(new Point(1, 2), plat, 'N');
    }

    /**
     * Test of getCoordinates method, of class Rover.
     */
    @Test
    public void testGetCoordinates() {
        System.out.println("getCoordinates");
        Point expResult = new Point(1, 2);
        Point result = instance.getCoordinates();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDirection method, of class Rover.
     */
    @Test
    public void testGetDir() {
        System.out.println("getDir");
        char expResult = 'N';
        char result = instance.getDirection();
        assertEquals(expResult, result);
    }

//
    /**
     * Test of setDirection method, of class Rover.
     */
    @Test
    public void testSetDirection() {
        System.out.println("setDirection");
        char dir = 'N';
        char inst = 'L';
        char expResult = 'W';
        char result = instance.setDirection(dir, inst);
        assertEquals(expResult, result);

        expResult = 'S';
        result = instance.setDirection(result, inst);
        assertEquals(expResult, result);

        expResult = 'E';
        result = instance.setDirection(result, inst);
        assertEquals(expResult, result);

        expResult = 'N';
        result = instance.setDirection(result, inst);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Rover.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        String instructions = "LMLMLMLM";
        instance.move(instructions);
        assertEquals(instance.getCoordinates() + " " + instance.getDirection(), new Point(1, 2) + " N");
    }

}
