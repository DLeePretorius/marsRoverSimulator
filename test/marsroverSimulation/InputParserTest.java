/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marsroverSimulation;

import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Diane-Lee
 */
public class InputParserTest {
    
    Plateau plateau;

    /**
     * Test of parsePlateauBoundaries method, of class InputParser.
     */
    @Test
    public void testParsePlateauBoundaries() {
        System.out.println("parsePlateauBoundaries");
        Point expResult = new Point(5, 5);
        Point result = InputParser.parsePlateauBoundaries("5 5");
        assertEquals(expResult, result);
        plateau = new Plateau(new Point(5, 5));
    }

    /**
     * Test of parseRoverPosition method, of class InputParser.
     */
    @Test
    public void testParseRoverPosition() {
        System.out.println("parseRoverPosition");
        String rovPosition = "1 1 N";
        Rover expResult = new Rover(new Point(1, 1), plateau, 'N');
        Rover result = InputParser.parseRoverPosition(rovPosition, plateau);
        assertEquals(expResult.getCoordinates(), result.getCoordinates());
    }

    /**
     * Test of parseIntAndValidate method, of class InputParser.
     */
    @Test
    public void testParseIntAndValidate() {
        System.out.println("parseIntAndValidate");
        String s = "1";
        int expResult = 1;
        int result = InputParser.parseIntAndValidate(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of parseCharAndValidate method, of class InputParser.
     */
    @Test
    public void testParseCharAndValidate() {
        System.out.println("parseCharAndValidate");
        String x = "N";
        char expResult = 'N';
        char result = InputParser.parseCharAndValidate(x);
        assertEquals(expResult, result);
    }

}
