package marsroverSimulation;

import java.awt.Point;

/**
 *
 * @author Diane-Lee Pretorius
 */
public class Rover {

    private Point coordinates;
    private char direction;
    private Plateau plateau;

    /**
     * Rover's default constructor
     */
    public Rover() {
        coordinates = new Point();
        coordinates.x = 0;
        coordinates.y = 0;
        direction = 0;
    }

    /**
     * Rover's constructor with orientation
     *
     * @param plateauReceived the demarcated plateau for this mission
     * @param coordinatesReceived initial coordinates passed into the
     * constructor
     * @param directionReceived initial direction passed into the constructor
     */
    public Rover(Point coordinatesReceived, Plateau plateauReceived, char directionReceived) {
        plateau = plateauReceived;
        coordinates = new Point();
        coordinates.x = coordinatesReceived.x;
        coordinates.y = coordinatesReceived.y;
        //check if the direction is valid
        validateDirection(directionReceived);
        direction = directionReceived;
        //check if coordinates are within the plateau boundaries
        checkMapX(plateau.getDimensions().x);
        checkMapY(plateau.getDimensions().y);
    }

    /**
     * Set the rover's coordinates
     *
     * @param xCo the x-coordinate
     * @param yCo the y-coordinate
     */
    public void setCoordinates(int xCo, int yCo) {
        coordinates.x = xCo;
        coordinates.y = yCo;
    }

    /**
     * Set the direction the rover faces
     *
     * @param newDirection the new direction that needs to be set
     */
    public void setDirection(char newDirection) { // set the direction the rover faces
        validateDirection(newDirection);
        direction = newDirection;
    }

    /**
     * Move the rover North
     */
    public void moveNorth() {
        coordinates.y++;
    }

    /**
     * Move the rover South
     */
    public void moveSouth() {
        coordinates.y--;
    }

    /**
     * Move the rover East
     */
    public void moveEast() {
        coordinates.x++;
    }

    /**
     * Move the rover West
     */
    public void moveWest() {
        coordinates.x--;
    }

    /**
     * Get the rover's current coordinates
     *
     * @return the rover's current coordinates
     */
    public Point getCoordinates() {
        return coordinates;
    }

    /**
     * Get the direction the rover is facing
     *
     * @return the direction the rover is facing
     */
    public char getDirection() {
        return direction;
    }

    /**
     * Check if the x-coordinate is within the plateau boundaries
     *
     * @param roverXCoordinate the x-coordinate of the rover
     */
    private void checkMapX(int roverXCoordinate) {
        if (coordinates.x > roverXCoordinate || roverXCoordinate > 0) {
            System.out.println("The received x coordinate is off the demarcated plateau\n");
            System.exit(1);
        }
    }

    /**
     * Check if the y-coordinate is within the plateau boundaries
     *
     * @param roverYCoordinate the y-coordinate of the rover
     */
    private void checkMapY(int roverYCoordinate) {
        if (coordinates.y > roverYCoordinate || roverYCoordinate > 0) {
            System.out.println("The received y co-ordinate is off the demarcated plateau\n");
            System.exit(1);
        }
    }

    /**
     *
     * @param receivedDirection the direction that needs to be validated
     */
    private void validateDirection(char receivedDirection) {
        boolean valid;
        receivedDirection = Character.toUpperCase(receivedDirection);
        switch (receivedDirection) {
            case 'N':
            case 'E':
            case 'W':
            case 'S':
                valid = true;
                break;
            default:
                valid = false;
                break;
        }
        if (!valid) {
            System.out.println("Invalid rover direction: " + receivedDirection
                    + "\nAcceptable directions are: N,S,E,W.");
            System.exit(1);
        }
    }

    /**
     * Print out the position and orientation of the rover
     */
    public void printRoverInfo() {
        System.out.println("\nCurrent location and orientation is: " + coordinates.x + " " + coordinates.y + " "
                + direction);
    }

    /**
     * Set the direction of the rover
     *
     * @param currentDirection the rover's current direction
     * @param instruction the instruction to turn left (L) or right (R)
     * @return the direction
     */
    public char setDirection(char currentDirection, char instruction) {

        if (instruction == 'L') {
            switch (currentDirection) {
                case 'N':
                    currentDirection = 'W';
                    break;
                case 'W':
                    currentDirection = 'S';
                    break;
                case 'S':
                    currentDirection = 'E';
                    break;
                case 'E':
                    currentDirection = 'N';
                    break;
                default:
                    System.out.println("Incorrect Direction Received");
                    break;
            }
        } else if (instruction == 'R') {

            switch (currentDirection) {
                case 'N':
                    currentDirection = 'E';
                    break;
                case 'W':
                    currentDirection = 'N';
                    break;
                case 'S':
                    currentDirection = 'W';
                    break;
                case 'E':
                    currentDirection = 'S';
                    break;
                default:
                    System.out.println("Incorrect Direction Received");
                    break;
            }
        }

        return currentDirection;

    }

    /**
     * Execute the received instructions and move the rover accordingly
     *
     * @param instructions the instructions received from the input file
     */
    public void move(String instructions) {

        System.out.println("Executing instruction set: " + instructions);
        //Split the instructions into an array and then process them one by one
        String[] roverPath = instructions.split("");
        for (int instruction = 0; instruction < roverPath.length; instruction++) {
            if (roverPath[instruction].equals("L") || roverPath[instruction].equals("R")) {
                direction = setDirection(getDirection(), roverPath[instruction].charAt(0));
            } else if (roverPath[instruction].equals("M")) {
                switch (getDirection()) {
                    case 'N':
                        // Before moving North, check if the rover is about to move off the plateau.
                        if (getCoordinates().y >= plateau.getDimensions().y) {
                            System.out
                                    .println("Rover did not execute the following instructions"
                                            + " in order remain within the plateau boundaries\n"
                                            + instructions.substring(instruction, instructions.length()));
                            printRoverInfo();
                            System.exit(1);
                        } else {
                            // Move rover North if within plateau boundaries
                            moveNorth();
                        }
                        break;
                    case 'E':
                        //Before moving East, check if the rover is about to move off the plateau.
                        if (getCoordinates().x >= plateau.getDimensions().x) {
                            System.out
                                    .println("Rover did not execute the following instructions"
                                            + " in order remain within the plateau boundaries\n"
                                            + instructions.substring(instruction, instructions.length()));
                            printRoverInfo();
                            System.exit(1);
                        } else {
                            // Move rover East if within plateau boundaries
                            moveEast();
                        }
                        break;
                    case 'S':
                        //Before moving South, check if the rover is about to move off the plateau.
                        if (getCoordinates().y == 0) {
                            System.out
                                    .println("Rover did not execute the following instructions"
                                            + " in order remain within the plateau boundaries\n"
                                            + instructions.substring(instruction, instructions.length()));
                            printRoverInfo();
                            System.exit(1);
                        } else {
                            // Move rover South if within plateau boundaries
                            moveSouth();
                        }
                        break;
                    case 'W':
                        //Before moving West, check if the rover is about to move off the plateau.
                        if (getCoordinates().x == 0) {
                            System.out
                                    .println("Rover did not execute the following instructions"
                                            + " in order remain within the plateau boundaries\n"
                                            + instructions.substring(instruction, instructions.length()));
                            printRoverInfo();
                            System.exit(1);
                        } else {
                            // Move rover West if within plateau boundaries
                            moveWest();
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

}
