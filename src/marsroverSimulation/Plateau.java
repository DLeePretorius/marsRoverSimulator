package marsroverSimulation;

import java.awt.Point;

/**
 *
 * @author Diane-Lee Pretorius
 */
public class Plateau {

    private static Point maxDimensions;

    /**
     * Default constructor
     */
    public Plateau() {
        maxDimensions = new Point();
        maxDimensions.x = 0;
        maxDimensions.y = 0;
    }

    /**
     * Constructor with passed dimensions
     *
     * @param dimensions the dimensions of the plateau
     */
    public Plateau(Point dimensions) {
        maxDimensions = new Point();
        maxDimensions.setLocation(dimensions.x, dimensions.y);
    }

    /**
     * Set the maximum dimensions of the plateau
     *
     * @param dimensions the maximum dimensions of the plateau
     */
    public void setMax(Point dimensions) {
        maxDimensions.x = dimensions.x;
        maxDimensions.y = dimensions.y;
    }

    /**
     * Get the dimensions of the plateau
     *
     * @return the dimensions of the plateau
     */
    public static Point getDimensions() { 
        return maxDimensions;
    }

}
