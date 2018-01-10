package marsroverSimulation;

import java.util.Scanner;

/**
 *
 * @author Diane-Lee Pretorius
 */
public class MarsRover {

    /**
     * The name of the input file
     */
    public static final String FILENAME = "input.txt";

    public static void main(String[] args) {
        // Retrieve the input file
        Scanner scanRover = InputParser.retrieveFile(FILENAME);
        // Parse the information from the first line of the file to set the boundaries of the plateau
        Plateau marsPlateau = new Plateau(InputParser.parsePlateauBoundaries(scanRover.nextLine()));
        // Parse the information from the second line of the file to set the initial position of the rover
        Rover marsRover = InputParser.parseRoverPosition(scanRover.nextLine(), marsPlateau);
        // Parse the information from the third line of code to attain the instructions for the rover to execute
        marsRover.move(scanRover.next());
        // Print the rover's final position and orientation
        marsRover.printRoverInfo(); 
        System.exit(0);
    }
}
