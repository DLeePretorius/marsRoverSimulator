package marsroverSimulation;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Diane-Lee Pretorius
 */
public final class InputParser {

    /**
     * Default constructor to prevent initialization
     */
    private InputParser() {
    }

    /**
     * Try to retrieve the file from the specified directory
     *
     * @param fileName the name of the file
     * @return the input.txt file
     */
    public static Scanner retrieveFile(String fileName) {
        Scanner scanFile = null;
        String fullPath = System.getProperty("user.dir") + "/" + fileName;
        try {
            scanFile = new Scanner(new FileReader(fullPath));
        } catch (FileNotFoundException e1) {
            System.out.println("File not found in directory: " + fullPath + ". \nPlease "
                    + "ensure file is in the correct folder.\n Error: " + e1);
            System.exit(1);
        }
        return scanFile;
    }

    /**
     * Parse the file input for the plateau boundaries
     *
     * @param receivedBoundaries the boundaries from the first line of the file
     * @return the boundaries of the plateau
     */
    public static Point parsePlateauBoundaries(String receivedBoundaries) {
        receivedBoundaries = receivedBoundaries.trim().replaceAll("\\s{2,}", " ");
        Point p = new Point();
        String[] boundaries = receivedBoundaries.split(" ");
        p.x = InputParser.parseIntAndValidate(boundaries[0]);
        p.y = InputParser.parseIntAndValidate(boundaries[1]);
        return p;
    }

    /**
     * Parse the file input for the initial rover position
     *@param plateau the demarcated plateau
     * @param initialPosition the initial position of the rover
     * @return Rover in the initial position
     */
    public static Rover parseRoverPosition(String initialPosition, Plateau plateau) {
        initialPosition = initialPosition.trim().replaceAll("\\s{2,}", " ");
        Point roverCo = new Point();
        String[] xyRov = initialPosition.split(" ");
        roverCo.x = parseIntAndValidate(xyRov[0]);
        roverCo.y = parseIntAndValidate(xyRov[1]);
        Rover rov = new Rover(roverCo, plateau, parseCharAndValidate(xyRov[2]));
        return rov;
    }

    /**
     * Ensure that the integers that are passed as strings are valid
     *
     * @param integer the integer to parse
     * @return the parsed integer
     */
    public static int parseIntAndValidate(String integer) {
        int validInt = 0;
        try {
            validInt = Integer.parseInt(integer);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error encountered when parsing integer: " + integer + "\nError: " + e + "\n");
            System.exit(1);
        }
        return validInt;
    }

    /**
     * Ensure that the chars that are passed as strings are valid
     *
     * @param character the character to parse
     * @return the parsed character
     */
    public static char parseCharAndValidate(String character) {
        char orientation = 0;
        try {
            orientation = character.charAt(0);
        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error encountered when parsing character: " + character + "\nError: " + e + "\n");
            System.exit(1);
        }
        return orientation;
    }
}
